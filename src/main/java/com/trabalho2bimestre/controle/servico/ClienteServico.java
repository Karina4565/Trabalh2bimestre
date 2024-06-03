
package com.trabalho2bimestre.controle.servico;

import com.trabalho2bimestre.conexao.FabricaConexao;
import com.trabalho2bimestre.controle.DAO.ClienteDAO;
import com.trabalho2bimestre.controle.DAO.DAOAbstrato;
import com.trabalho2bimestre.modelo.Cliente;
import java.sql.Connection;



public class ClienteServico {
    
    private static Connection abrirConexaoBD() throws Exception {
        try {
           return FabricaConexao.getConnectionMysql();
        } catch (Exception e) {
            throw new Exception("Erro ao conectar no banco de dados: " + e.getMessage());
        }
    }
    
    private static void fecharConexaoBD(Connection conn){
            DAOAbstrato.fecharRecursos(conn, null, null);
    }
    
    public static void inserirCliente(Cliente cliente) throws Exception  {
        
        Connection conn = abrirConexaoBD();
        ClienteDAO clienteDAO = new ClienteDAO(conn);
        
        clienteDAO.inserir(cliente);
 
    }
    
     public static void atualizarCliente(Cliente cliente) throws Exception{
     
        Connection conn = abrirConexaoBD();
        ClienteDAO clienteDAO = new ClienteDAO(conn);
        
        clienteDAO.atualizar(cliente);
     
     if (cliente.getId() == null){
            clienteDAO.inserir(cliente);
        } else {
            clienteDAO.atualizar(cliente);
        }
        
        fecharConexaoBD(conn);
    }
    
}

