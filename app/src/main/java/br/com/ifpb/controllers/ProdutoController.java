package br.com.ifpb.controllers;

import br.com.ifpb.dao.ProdutoDao;
import br.com.ifpb.model.Produto;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProdutoController implements Serializable {

    @EJB
    private ProdutoDao produtos;
    private Produto produto = new Produto();

    public void criarProduto(Produto produto){
        produtos.criar(produto);
    }

    public void editarProduto(Produto produto){
        produtos.editar(produto);
    }

    public void excluirProduto(Produto produto){
        produtos.excluir(produto);
    }

    public List<Produto> listarProdutos(){
        return produtos.listar();
    }
    public List<Produto> listarProdutosPorDescricao(){
        return produtos.listarProdutoPorDescricao();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
