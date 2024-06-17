package com.trabalho2bimestre.controle.servico;

import com.trabalho2bimestre.conexao.FabricaConexao;
import com.trabalho2bimestre.controle.DAO.TreinoClienteDAO;
import com.trabalho2bimestre.controle.DAO.DAOAbstrato;
import com.trabalho2bimestre.modelo.TreinoCliente;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class TreinoClienteServico {

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

    public static void inserirTreinoCliente(TreinoCliente treinoCliente) throws Exception {
        Connection conn = abrirConexaoBD();
        TreinoClienteDAO treinoClienteDAO = new TreinoClienteDAO(conn);
       
     
        treinoClienteDAO.inserir(treinoCliente);

        fecharConexaoBD(conn);
    }

    public static void atualizarTreinoCliente(TreinoCliente treinoCliente) throws Exception {
       
        Connection conn = abrirConexaoBD();
        TreinoClienteDAO treinoClienteDAO = new TreinoClienteDAO(conn);

        treinoClienteDAO.atualizar(treinoCliente);

        fecharConexaoBD(conn);
    }

  
    public static void excluirTreinoCliente(TreinoCliente treinoCliente) throws Exception {
        Connection conn = abrirConexaoBD();
        TreinoClienteDAO treinoClienteDAO = new TreinoClienteDAO(conn);
        
      
        fecharConexaoBD(conn);
    }
    
 

    public static List<TreinoCliente> todasTreinoClientes() {
        Connection conn = null;
        List<TreinoCliente> treinoClientes = null;

        try {
            conn = abrirConexaoBD();
            TreinoClienteDAO treinoClienteDAO = new TreinoClienteDAO(conn);
            treinoClientes = treinoClienteDAO.listar();
        } catch (Exception e) {
            System.out.println("Não foi possível listar os treinoClientes.");
        } finally {
            if (conn != null) {
                fecharConexaoBD(conn);
            }
        }

        return treinoClientes;
    }
}
