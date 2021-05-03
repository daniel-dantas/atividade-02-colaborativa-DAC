package br.com.ifpb.controllers;

import br.com.ifpb.Venda;
import br.com.ifpb.model.Cliente;
import br.com.ifpb.model.Produto;

import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class CarrinhoDeCompras {

    private Cliente cliente;
    private final Venda venda = new Venda();

    public void adicionar(Produto produto) {
        this.venda.adicionar(produto);
    }
    public void remover(Produto produto) {
        this.venda.remover(produto);
    }

    @Remove
    public void finalizar(Cliente cliente) {
        this.venda.finalizar(cliente);
        // TODO: processar pagamento
        // TODO: enviar confirmação do pedido
    }
}
