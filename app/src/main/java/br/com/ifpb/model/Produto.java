package br.com.ifpb.model;

import java.math.BigDecimal;

public class Produto {
    private int id;
    private String descricao;
    private BigDecimal valor;
}

    public boolean valido() {
        return !"".equals(this.valor.trim())
                && !"".equals(this.descricao.trim());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id && descricao.equals(produto.descricao) && valor.equals(produto.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, valor);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
