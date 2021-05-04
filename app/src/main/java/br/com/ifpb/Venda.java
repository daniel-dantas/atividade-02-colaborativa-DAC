package br.com.ifpb;

import br.com.ifpb.model.Cliente;
import br.com.ifpb.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private final List<Produto> carrinho = new ArrayList<>();
    private Cliente cliente;

    public void adicionar(Produto produto){
        this.carrinho.add(produto);
    }

    public void remover(Produto produto){
        this.carrinho.remove(produto);
    }

    public void finalizar(Cliente cliente) {

    }
}
