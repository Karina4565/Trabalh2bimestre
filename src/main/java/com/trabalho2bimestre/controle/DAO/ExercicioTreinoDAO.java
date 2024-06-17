package com.trabalho2bimestre.controle.DAO;

import static com.trabalho2bimestre.controle.DAO.DAOAbstrato.fecharRecursos;
import com.trabalho2bimestre.modelo.ExercicioTreino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExercicioTreinoDAO extends DAOAbstrato {

    private static final String INSERIR = "INSERT INTO Exercicio_treino"
            + "(treino_id, exercicio_id, series, repeticoes, observacoes) "
            + "VALUES (?, ?, ?, ?, ?)";

    private static final String ATUALIZAR = "UPDATE Exercicio_treino SET "
        + "treino_id = ?, "
        + "exercicio_id = ?, "
        + "series = ?, " 
        + "repeticoes = ?, "
        + "observacoes = ? "
        + "WHERE id = ?";


    private static final String EXCLUIR = "DELETE FROM exercicio_Treino WHERE id = ?";
    private static final String PESQUISAR = "SELECT * FROM exercicio_Treino";

    public ExercicioTreinoDAO(Connection conn) {
        super(conn);
    }

    public void inserir(ExercicioTreino exercicioTreino) throws Exception {
        try {
            psmt = conn.prepareStatement(INSERIR, PreparedStatement.RETURN_GENERATED_KEYS);

            psmt.setInt(1, exercicioTreino.getIdTreino());
            psmt.setInt(2, exercicioTreino.getIdExercicio());
            psmt.setInt(3, exercicioTreino.getSeries());
            psmt.setInt(4, exercicioTreino.getRepeticoes());
            psmt.setString(5, exercicioTreino.getObservacoes());

            int res = psmt.executeUpdate();

            if (res == 1) {
                rs = psmt.getGeneratedKeys();
                rs.next();
                exercicioTreino.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir ExercicioTreino: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, rs);
        }
    }

    public void atualizar(ExercicioTreino exercicioTreino) throws Exception {
        try {
            psmt = conn.prepareStatement(ATUALIZAR);
            psmt.setInt(1, exercicioTreino.getIdTreino());
            psmt.setInt(2, exercicioTreino.getIdExercicio());
            psmt.setInt(3, exercicioTreino.getSeries());
            psmt.setInt(4, exercicioTreino.getRepeticoes());
            psmt.setString(5, exercicioTreino.getObservacoes());
            psmt.setInt(6, exercicioTreino.getId());

            psmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar ExercicioTreino: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, null);
        }
    }

    public void excluir(ExercicioTreino exercicioTreino) throws Exception {
        try {
            psmt = conn.prepareStatement(EXCLUIR);
            psmt.setInt(1, exercicioTreino.getId());

            psmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao excluir ExercicioTreino: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, null);
        }
    }

    public List<ExercicioTreino> listar() {
        List<ExercicioTreino> lista = new ArrayList<ExercicioTreino>();
        try {
            psmt = conn.prepareStatement(PESQUISAR);
            rs = psmt.executeQuery();

              while (rs.next()) {
                ExercicioTreino exercicioTreino = new ExercicioTreino();

                exercicioTreino.setId(rs.getInt("id"));
                exercicioTreino.setIdTreino(rs.getInt("treino_id"));
                exercicioTreino.setIdExercicio(rs.getInt("exercicio_id"));
                exercicioTreino.setSeries(rs.getInt("series"));
                exercicioTreino.setRepeticoes(rs.getInt("repeticoes"));
                exercicioTreino.setObservacoes(rs.getString("observacoes"));

                lista.add(exercicioTreino);
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível realizar a listagem dos exercicioTreinos.");
        } finally {
            fecharRecursos(null, psmt, rs);
        }
        return lista;
    }
}
