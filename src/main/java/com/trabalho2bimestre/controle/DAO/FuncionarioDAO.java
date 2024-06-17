package com.trabalho2bimestre.controle.DAO;

import static com.trabalho2bimestre.controle.DAO.DAOAbstrato.fecharRecursos;
import com.trabalho2bimestre.modelo.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends DAOAbstrato {

    private static final String INSERIR = "INSERT INTO funcionario"
            + "(nome, email, telefone) "
            + "VALUES (?, ?, ?)";

    private static final String ATUALIZAR = "UPDATE funcionario SET "
        + "nome = ?, "
        + "email = ?, "
        + "telefone = ? "
        + "WHERE id = ?";


    private static final String EXCLUIR = "DELETE FROM funcionario WHERE id = ?";
    private static final String PESQUISAR = "SELECT * FROM funcionario";

    public FuncionarioDAO(Connection conn) {
        super(conn);
    }

    public void inserir(Funcionario funcionario) throws Exception {
        try {
            psmt = conn.prepareStatement(INSERIR, PreparedStatement.RETURN_GENERATED_KEYS);

            psmt.setString(1, funcionario.getNome());
            psmt.setString(2, funcionario.getEmail());
            psmt.setString(3, funcionario.getTelefone());

            int res = psmt.executeUpdate();

            if (res == 1) {
                rs = psmt.getGeneratedKeys();
                rs.next();
                funcionario.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Funcionario: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, rs);
        }
    }

    public void atualizar(Funcionario funcionario) throws Exception {
        try {
            psmt = conn.prepareStatement(ATUALIZAR);
            psmt.setString(1, funcionario.getNome());
            psmt.setString(2, funcionario.getEmail());
            psmt.setString(3, funcionario.getTelefone());
            psmt.setInt(4, funcionario.getId());

            psmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Funcionario: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, null);
        }
    }

    public void excluir(Funcionario funcionario) throws Exception {
        try {
            psmt = conn.prepareStatement(EXCLUIR);
            psmt.setInt(1, funcionario.getId());

            psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir Funcionario: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, null);
        }
    }

    public List<Funcionario> listar() {
        List<Funcionario> lista = new ArrayList<Funcionario>();
        try {
            psmt = conn.prepareStatement(PESQUISAR);
            rs = psmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setId(rs.getInt(1));
                funcionario.setNome(rs.getString(2));
                funcionario.setEmail(rs.getString(3));
                funcionario.setTelefone(rs.getString(4));

                lista.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível realizar a listagem dos funcionarios.");
        } finally {
            fecharRecursos(null, psmt, rs);
        }
        return lista;
    }
}
