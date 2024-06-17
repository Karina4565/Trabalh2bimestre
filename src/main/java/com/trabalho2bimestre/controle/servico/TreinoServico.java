package com.trabalho2bimestre.controle.servico;

import com.trabalho2bimestre.conexao.FabricaConexao;
import com.trabalho2bimestre.controle.DAO.TreinoDAO;
import com.trabalho2bimestre.controle.DAO.TreinoDAO;
import com.trabalho2bimestre.controle.DAO.DAOAbstrato;
import com.trabalho2bimestre.modelo.Treino;
import com.trabalho2bimestre.modelo.Treino;
import java.sql.Connection;
import java.util.List;

public class TreinoServico {

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

    public static void inserirTreino(Treino treino) throws Exception {
        if (!validarCampos(treino)) {
            return;
        }

        Connection conn = abrirConexaoBD();
        TreinoDAO treinoDAO = new TreinoDAO(conn);

        treinoDAO.inserir(treino);

        fecharConexaoBD(conn);
    }

    public static void atualizarTreino(Treino treino) throws Exception {
        if (!validarCampos(treino)) {
            return;
        }

        Connection conn = abrirConexaoBD();
        TreinoDAO treinoDAO = new TreinoDAO(conn);

        treinoDAO.atualizar(treino);

        fecharConexaoBD(conn);
    }

    private static boolean validarCampos(Treino treino) {
        if (treino.getNome() == null || treino.getNome().isEmpty() || treino.getNome().length() > 100) {
            System.out.println("Erro: Nome não pode ser vazio e deve ter no máximo 100 caracteres.");
            return false;
        }



        return true;
    }

    public static void excluirTreino(Treino treino) throws Exception {
        Connection conn = abrirConexaoBD();
        TreinoDAO treinoDAO = new TreinoDAO(conn);
        treinoDAO.excluir(treino);
        fecharConexaoBD(conn);
    }
  
    public static List<Treino> todasTreinos() {
        Connection conn = null;
        List<Treino> treinos = null;

        try {
            conn = abrirConexaoBD();
            TreinoDAO treinoDAO = new TreinoDAO(conn);
            treinos = treinoDAO.listar();
             fecharConexaoBD(conn);
        } catch (Exception e) {
            System.out.println("Não foi possível listar os treinos.");
        } finally {
            if (conn != null) {
                fecharConexaoBD(conn);
            }
        }

        return treinos;
    }
}
