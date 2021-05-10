package br.com.ifpb.utils;

import br.com.ifpb.model.Cliente;
import br.com.ifpb.model.Item;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venda implements Serializable {

    private final List<Item> carrinho = new ArrayList<>();
    private String cliente;

    public void adicionar(String produto){
        Item item = new Item(produto);
        this.carrinho.add(item);
    }

    public void incrementar(String produto) {
        this.carrinho.stream()
                .filter(item -> item.getProduto().equals(produto))
                .findFirst()
                .get()
                .incrementar();
    }

    public void decrementar(String produto) {
        this.carrinho.stream()
                .filter(item -> item.getProduto().equals(produto))
                .findFirst()
                .get()
                .decrementar();
    }
    public void remover(String produto){
        Item item = new Item(produto);

        this.carrinho.remove(item);
    }

    public List<Item> itens() {
        return Collections.unmodifiableList(
                carrinho
        );
    }
    public void finalizar(Cliente cliente) {
        this.cliente = cliente.getNome();
        System.out.println("--- Carrinho de compras ---");
        this.carrinho.forEach(
                p -> System.out.println(p.getProduto())
        );
        double total = this.carrinho
                .stream()
                .mapToDouble(Item::getValor)
                .sum();
        System.out.println("--- Total da compra:" + total + " ---");
        System.out.println("--- Carrinho finalizado ---");
    }
}
