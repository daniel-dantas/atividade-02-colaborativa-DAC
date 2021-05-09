package br.com.ifpb.dao;

import br.com.ifpb.model.Cliente;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class ClienteDao {

    @Resource(lookup = "java:app/jdbc/pgadmin")
    private DataSource dataSource;


    public void criar(Cliente cliente){
        try {
            PreparedStatement statement = this.dataSource
                    .getConnection()
                    .prepareStatement(
                            "INSERT INTO clientes (cpf, nome) VALUES(?,?) "
                    );
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());

            statement.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void editar(Cliente cliente) {
        try {
            PreparedStatement statement = this.dataSource
                    .getConnection()
                    .prepareStatement("UPDATE cliente SET nome = ? , cpf = ? WHERE id = ?");
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setInt(3,cliente.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
    }

    public void excluir(Cliente cliente){
        try {
            PreparedStatement statement = this.dataSource
                    .getConnection().prepareStatement("DELETE FROM cliente WHERE id = ?");
            statement.setInt(1, cliente.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
    }

    public List<Cliente> listar(){
        try {
            List<Cliente> lista = new ArrayList<>();
            ResultSet result = this.dataSource
                    .getConnection()
                    .prepareStatement(
                            "SELECT * FROM clientes"
                    ).executeQuery();
            while (result.next()) {
                lista.add(
                        criarCliente(result)
                );
            }
            return lista;
        } catch (SQLException ex) {
//            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE,null,ex);
            return Collections.EMPTY_LIST;
        }
    }


    private Cliente criarCliente(ResultSet result) throws SQLException {
        String nome = result.getString("nome");
        String cpf = result.getString("cpf");
        int id = result.getInt("id");
        return new Cliente(id,cpf,nome);
    }


}
