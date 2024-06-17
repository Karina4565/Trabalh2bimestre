package com.trabalho2bimestre.controle.servico;

import com.trabalho2bimestre.conexao.FabricaConexao;
import com.trabalho2bimestre.controle.DAO.ExercicioDAO;
import com.trabalho2bimestre.controle.DAO.ExercicioDAO;
import com.trabalho2bimestre.controle.DAO.DAOAbstrato;
import com.trabalho2bimestre.modelo.Exercicio;
import com.trabalho2bimestre.modelo.Exercicio;
import java.sql.Connection;
import java.util.List;

public class ExercicioServico {

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

    public static void inserirExercicio(Exercicio exercicio) throws Exception {
        if (!validarCampos(exercicio)) {
            return;
        }

        Connection conn = abrirConexaoBD();
        ExercicioDAO exercicioDAO = new ExercicioDAO(conn);

        exercicioDAO.inserir(exercicio);

        fecharConexaoBD(conn);
    }

    public static void atualizarExercicio(Exercicio exercicio) throws Exception {
        if (!validarCampos(exercicio)) {
            return;
        }

        Connection conn = abrirConexaoBD();
        ExercicioDAO exercicioDAO = new ExercicioDAO(conn);

        exercicioDAO.atualizar(exercicio);

        fecharConexaoBD(conn);
    }

    private static boolean validarCampos(Exercicio exercicio) {
        if (exercicio.getNome() == null || exercicio.getNome().isEmpty() || exercicio.getNome().length() > 100) {
            System.out.println("Erro: Nome não pode ser vazio e deve ter no máximo 100 caracteres.");
            return false;
        }



        return true;
    }

    public static void excluirExercicio(Exercicio exercicio) throws Exception {
        Connection conn = abrirConexaoBD();
        ExercicioDAO exercicioDAO = new ExercicioDAO(conn);
        exercicioDAO.excluir(exercicio);
        fecharConexaoBD(conn);
    }
  
    public static List<Exercicio> todasExercicios() {
        Connection conn = null;
        List<Exercicio> exercicios = null;

        try {
            conn = abrirConexaoBD();
            ExercicioDAO exercicioDAO = new ExercicioDAO(conn);
            exercicios = exercicioDAO.listar();
            fecharConexaoBD(conn);
        } catch (Exception e) {
            System.out.println("Não foi possível listar os exercicios.");
        } finally {
            if (conn != null) {
                fecharConexaoBD(conn);
            }
        }

        return exercicios;
    }
}
