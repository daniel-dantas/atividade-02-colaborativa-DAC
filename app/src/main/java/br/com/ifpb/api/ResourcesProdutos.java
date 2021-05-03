package br.com.ifpb.api;

import br.com.ifpb.controllers.ProdutoController;
import br.com.ifpb.model.Produto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("produtos")
@Stateless
public class ResourcesProdutos {

    @EJB
    private ProdutoController produtos;

    @GET
    @Produces("application/json")
    public List<Produto> listarProdutosPorDescricao(){
        return produtos.listarProdutosPorDescricao();
    }

    @GET
    @Produces("application/json")
    public List<Produto> listarProdutos() {
        return produtos.listarProdutos();
    }
}
