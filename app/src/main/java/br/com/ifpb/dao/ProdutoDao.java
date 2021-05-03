package br.com.ifpb.dao;

import br.com.ifpb.model.Produto;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class ProdutoDao {

    @Resource(lookup = "java:app/jdbc/pgadmin")
    private DataSource dataSource;


    public void criar(Produto produto){
        try {
            PreparedStatement statement = this.dataSource
                    .getConnection()
                    .prepareStatement(
                            "INSERT INTO produtos (descricao, valor) VALUES(?,?) "
                    );
            statement.setString(1, produto.getDescricao());
            statement.setBigDecimal(2, produto.getValor());

            statement.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void editar(Produto produto) {
        try {
            PreparedStatement statement = this.dataSource
                    .getConnection()
                    .prepareStatement("UPDATE produtos SET descricao = ? , valor = ? WHERE id = ?");
            statement.setString(1, produto.getDescricao());
            statement.setBigDecimal(2, produto.getValor());
            statement.setInt(3,produto.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
    }

    public void excluir(Produto produto){
        try {
            PreparedStatement statement = this.dataSource
                    .getConnection().prepareStatement("DELETE FROM produtos WHERE id = ?");
            statement.setInt(1, produto.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
    }

    public List<Produto> listar(){
        try {
            List<Produto> lista = new ArrayList<>();
            ResultSet result = this.dataSource
                    .getConnection()
                    .prepareStatement(
                            "SELECT * FROM produtos"
                    ).executeQuery();
            while (result.next()) {
                lista.add(
                        criarProduto(result)
                );
            }
            return lista;
        } catch (SQLException ex) {
//            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE,null,ex);
            return Collections.EMPTY_LIST;
        }
    }


    private Produto criarProduto(ResultSet result) throws SQLException {
        String descricao = result.getString("descricao");
        BigDecimal valor = result.getBigDecimal("valor");
        int id = result.getInt("id");
        return new Produto(id, descricao, valor);
    }

}
