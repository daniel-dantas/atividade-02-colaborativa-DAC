package br.com.ifpb.utils;

import br.com.ifpb.model.Cliente;
import br.com.ifpb.model.Item;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.List;

@Stateful
public class CarrinhoDeCompras  {

    private final Venda venda = new Venda();
    private Cliente cliente;

    public void adicionar(String produto) {
        this.venda.adicionar(produto);
    }
    public void remover(String produto) {
        this.venda.remover(produto);
    }
    public void incrementar(String produto) { this.venda.incrementar(produto);}
    public void decrementar(String produto) {  this.venda.decrementar(produto);}
    public List<Item> itens() {return this.venda.itens();}

    @Remove
    public void finalizar(Cliente cliente) {
        this.venda.finalizar(cliente);
    }
}
