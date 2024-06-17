package com.trabalho2bimestre.controle.servico;

import com.trabalho2bimestre.conexao.FabricaConexao;
import com.trabalho2bimestre.controle.DAO.ExercicioTreinoDAO;
import com.trabalho2bimestre.controle.DAO.DAOAbstrato;
import com.trabalho2bimestre.modelo.ExercicioTreino;
import java.sql.Connection;
import java.util.List;

public class ExercicioTreinoServico {

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

    public static void inserirExercicioTreino(ExercicioTreino exercicioTreino) throws Exception {
        

        Connection conn = abrirConexaoBD();
        ExercicioTreinoDAO exercicioTreinoDAO = new ExercicioTreinoDAO(conn);

        exercicioTreinoDAO.inserir(exercicioTreino);

        fecharConexaoBD(conn);
    }

    public static void atualizarExercicioTreino(ExercicioTreino exercicioTreino) throws Exception {
       

        Connection conn = abrirConexaoBD();
        ExercicioTreinoDAO exercicioTreinoDAO = new ExercicioTreinoDAO(conn);

        exercicioTreinoDAO.atualizar(exercicioTreino);

        fecharConexaoBD(conn);
    }

   
    public static void excluirExercicioTreino(ExercicioTreino exercicioTreino) throws Exception {
        Connection conn = abrirConexaoBD();
        ExercicioTreinoDAO exercicioTreinoDAO = new ExercicioTreinoDAO(conn);
        exercicioTreinoDAO.excluir(exercicioTreino);
        fecharConexaoBD(conn);
    }

    public static List<ExercicioTreino> todasExercicioTreinos() {
        Connection conn = null;
        List<ExercicioTreino> exercicioTreinos = null;

        try {
            conn = abrirConexaoBD();
            ExercicioTreinoDAO exercicioTreinoDAO = new ExercicioTreinoDAO(conn);
            exercicioTreinos = exercicioTreinoDAO.listar();
             fecharConexaoBD(conn);
        } catch (Exception e) {
            System.out.println("Não foi possível listar os exercicioTreinos.");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                fecharConexaoBD(conn);
            }
        }

        return exercicioTreinos;
    }
}
