package br.com.ifpb.controllers;

import br.com.ifpb.dao.ClienteDao;
import br.com.ifpb.model.Cliente;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ClienteController implements Serializable {

    @EJB
    private ClienteDao clientes;
    private Cliente cliente = new Cliente();

    public void criarCliente(Cliente cliente){
        clientes.criar(cliente);
    }

    public void editarCliente(Cliente cliente){
        clientes.editar(cliente);
    }

    public void excluirCliente(Cliente cliente){
        clientes.excluir(cliente);
    }

    public List<Cliente> listarClientes(){
        return clientes.listar();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
