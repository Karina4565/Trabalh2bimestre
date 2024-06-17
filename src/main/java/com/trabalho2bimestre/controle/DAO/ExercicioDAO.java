package com.trabalho2bimestre.controle.DAO;

import static com.trabalho2bimestre.controle.DAO.DAOAbstrato.fecharRecursos;
import com.trabalho2bimestre.modelo.Exercicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExercicioDAO extends DAOAbstrato {

    private static final String INSERIR = "INSERT INTO exercicio"
            + "(nome, descricao) "
            + "VALUES (?, ?)";

    private static final String ATUALIZAR = "UPDATE exercicio SET "
        + "nome = ?, "
        + "descricao = ? "
        + "WHERE id = ?";


    private static final String EXCLUIR = "DELETE FROM exercicio WHERE id = ?";
    private static final String PESQUISAR = "SELECT * FROM exercicio";

    public ExercicioDAO(Connection conn) {
        super(conn);
    }

    public void inserir(Exercicio exercicio) throws Exception {
        try {
            psmt = conn.prepareStatement(INSERIR, PreparedStatement.RETURN_GENERATED_KEYS);

            psmt.setString(1, exercicio.getNome());
            psmt.setString(2, exercicio.getDescricao());

            int res = psmt.executeUpdate();

            if (res == 1) {
                rs = psmt.getGeneratedKeys();
                rs.next();
                exercicio.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Exercicio: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, rs);
        }
    }

    public void atualizar(Exercicio exercicio) throws Exception {
        try {
            psmt = conn.prepareStatement(ATUALIZAR);
            psmt.setString(1, exercicio.getNome());
            psmt.setString(2, exercicio.getDescricao());
            psmt.setInt(3, exercicio.getId());

            psmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Exercicio: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, null);
        }
    }

    public void excluir(Exercicio exercicio) throws Exception {
        try {
            psmt = conn.prepareStatement(EXCLUIR);
            psmt.setInt(1, exercicio.getId());

            psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir Exercicio: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, null);
        }
    }

    public List<Exercicio> listar() {
        List<Exercicio> lista = new ArrayList<Exercicio>();
        try {
            psmt = conn.prepareStatement(PESQUISAR);
            rs = psmt.executeQuery();

            while (rs.next()) {
                Exercicio exercicio = new Exercicio();

                exercicio.setId(rs.getInt(1));
                exercicio.setNome(rs.getString(2));
                exercicio.setDescricao(rs.getString(3));

                lista.add(exercicio);
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível realizar a listagem dos exercicios.");
        } finally {
            fecharRecursos(null, psmt, rs);
        }
        return lista;
    }
}
