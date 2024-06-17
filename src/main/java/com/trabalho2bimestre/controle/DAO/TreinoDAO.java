package com.trabalho2bimestre.controle.DAO;

import static com.trabalho2bimestre.controle.DAO.DAOAbstrato.fecharRecursos;
import com.trabalho2bimestre.modelo.Treino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreinoDAO extends DAOAbstrato {

    private static final String INSERIR = "INSERT INTO treino"
            + "(nome, descricao) "
            + "VALUES (?, ?)";

    private static final String ATUALIZAR = "UPDATE treino SET "
        + "nome = ?, "
        + "descricao = ? "
        + "WHERE id = ?";


    private static final String EXCLUIR = "DELETE FROM treino WHERE id = ?";
    private static final String PESQUISAR = "SELECT * FROM treino";

    public TreinoDAO(Connection conn) {
        super(conn);
    }

    public void inserir(Treino treino) throws Exception {
        try {
            psmt = conn.prepareStatement(INSERIR, PreparedStatement.RETURN_GENERATED_KEYS);

            psmt.setString(1, treino.getNome());
            psmt.setString(2, treino.getDescricao());

            int res = psmt.executeUpdate();

            if (res == 1) {
                rs = psmt.getGeneratedKeys();
                rs.next();
                treino.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Treino: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, rs);
        }
    }

    public void atualizar(Treino treino) throws Exception {
        try {
            psmt = conn.prepareStatement(ATUALIZAR);
            psmt.setString(1, treino.getNome());
            psmt.setString(2, treino.getDescricao());
            psmt.setInt(3, treino.getId());

            psmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Treino: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, null);
        }
    }

    public void excluir(Treino treino) throws Exception {
        try {
            psmt = conn.prepareStatement(EXCLUIR);
            psmt.setInt(1, treino.getId());

            psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir Treino: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, null);
        }
    }

    public List<Treino> listar() {
        List<Treino> lista = new ArrayList<Treino>();
        try {
            psmt = conn.prepareStatement(PESQUISAR);
            rs = psmt.executeQuery();

            while (rs.next()) {
                Treino treino = new Treino();

                treino.setId(rs.getInt(1));
                treino.setNome(rs.getString(2));
                treino.setDescricao(rs.getString(3));

                lista.add(treino);
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível realizar a listagem dos treinos.");
        } finally {
            fecharRecursos(null, psmt, rs);
        }
        return lista;
    }
}
