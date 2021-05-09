package br.com.ifpb.controllers;

import br.com.ifpb.CarrinhoDeCompras;
import br.com.ifpb.model.Cliente;
import br.com.ifpb.model.Item;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.spi.CDI;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CarrinhoController implements Serializable {

        @EJB
        private CarrinhoDeCompras carrinho;
        private Cliente cliente = new Cliente();

        public void adcionar(String produto) {
            carrinho.adicionar(produto);
        }

        public void remover(String produto) {
            carrinho.remover(produto);
        }

        public List<Item> todosOsProdutos() {
            return this.carrinho.itens();
        }

        public String checkout() {
            this.carrinho.finalizar(this.cliente);
            // TODO: uma nova instância para o carrinho
            recuperarNovaInstanciaCarrinho();
            // logout
            // logout();
            return "index?faces-redirect=true";
        }

        private void recuperarNovaInstanciaCarrinho() {
            System.out.println("renovando a instância");
            this.carrinho = CDI.current()
                    .select(CarrinhoDeCompras.class)
                    .get();
        }

        public String incrementar(String produto) {
            this.carrinho.incrementar(produto);
            return null;
        }

        public String decrementar(String produto) {
            this.carrinho.decrementar(produto);
            return null;
        }

        private void logout() {
            HttpSession session = (HttpSession) FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .getSession(true);
            session.invalidate();
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

}

