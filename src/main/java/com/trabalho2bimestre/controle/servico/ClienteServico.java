package com.trabalho2bimestre.controle.servico;

import com.trabalho2bimestre.conexao.FabricaConexao;
import com.trabalho2bimestre.controle.DAO.ClienteDAO;
import com.trabalho2bimestre.controle.DAO.DAOAbstrato;
import com.trabalho2bimestre.modelo.Cliente;
import java.sql.Connection;
import java.util.List;

public class ClienteServico {
    
    private static Connection abrirConexaoBD() throws Exception {
        try {
            return FabricaConexao.getConnectionMysql();
        } catch (Exception e) {
            throw new Exception("Erro ao conectar no banco de dados: " + e.getMessage());
        }
    }
    
    private static void fecharConexaoBD(Connection conn) {
        DAOAbstrato.fecharRecursos(conn, null, null);
    }
    
    public static void inserirCliente(Cliente cliente) throws Exception  {
        
        Connection conn = abrirConexaoBD();
        ClienteDAO clienteDAO = new ClienteDAO(conn);
        
        clienteDAO.inserir(cliente);

 
    }
    
    public static void atualizarCliente(Cliente cliente) throws Exception {
     
        Connection conn = abrirConexaoBD();
        ClienteDAO clienteDAO = new ClienteDAO(conn);
        
        clienteDAO.atualizar(cliente);
        
        if (validarData(cliente)) {
            System.out.println("Data inválida!");
        } else if (cliente.getId() == null) {
            clienteDAO.inserir(cliente);
        } else {
            clienteDAO.atualizar(cliente);
        }
        
        fecharConexaoBD(conn);
    }
     
    private static boolean validarData(Cliente cliente) {
        // return cliente.getDataNascimento() > LocalDate.of(2008, 1, 01);
        return false;
    }
    
    public static void excluirCliente(Cliente cliente) throws Exception {
        Connection conn = abrirConexaoBD();
        ClienteDAO clienteDAO = new ClienteDAO(conn);
        clienteDAO.excluir(cliente);
        fecharConexaoBD(conn);
    }
     
    public static List<Cliente> todasClientes() {
        Connection conn = null;
        List<Cliente> clientes = null;

        try {
            conn = abrirConexaoBD();
            ClienteDAO clienteDAO = new ClienteDAO(conn);
            clientes = clienteDAO.listar();
        } catch (Exception e) {
            System.out.println("Não foi possível listar os clientes.");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                fecharConexaoBD(conn);
            }
        }

        return clientes;
    }
}