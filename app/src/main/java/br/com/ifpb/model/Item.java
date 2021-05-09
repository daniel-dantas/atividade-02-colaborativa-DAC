package br.com.ifpb.model;

public class Item {
    private String produto;
    private double valor;
    private int quantidade = 1;

    public Item(String produto) {

    }
    public Item(String produto, double valor, int quantidade) {
        this.produto = produto;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public void incrementar() {
        this.quantidade++;
    }

    public void decrementar() {
        this.quantidade--;
    }
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
