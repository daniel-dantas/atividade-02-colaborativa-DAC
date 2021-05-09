package br.com.ifpb.controllers;

import br.com.ifpb.Venda;
import br.com.ifpb.model.Cliente;

import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class CarrinhoDeCompras  {

    private Cliente cliente;
    private final Venda venda = new Venda();

    public void adicionar(String produto) {
        this.venda.adicionar(produto);
    }
    public void remover(String produto) {
        this.venda.remover(produto);
    }

    @Remove
    public void finalizar(Cliente cliente) {
        this.venda.finalizar(cliente);
    }
}
