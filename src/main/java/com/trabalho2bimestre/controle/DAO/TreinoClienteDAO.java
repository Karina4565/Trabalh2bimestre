package com.trabalho2bimestre.controle.DAO;

import static com.trabalho2bimestre.controle.DAO.DAOAbstrato.fecharRecursos;
import com.trabalho2bimestre.modelo.TreinoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreinoClienteDAO extends DAOAbstrato {

    private static final String INSERIR = "INSERT INTO treinoCliente"
            + "(cliente_id, treino_id, funcionario_id, data_inicio,data_fim ) "
            + "VALUES (?, ?, ?, ?)";

    private static final String ATUALIZAR = "UPDATE treinoCliente SET "
        + "cliente_id = ?, "
        + "treino_id = ?, "
        + "funcionario_id = ?, "
        + "data_inicio = ?, "
        + "data_fim = ? "
        + "WHERE id = ?";


    private static final String EXCLUIR = "DELETE FROM treinoCliente WHERE id = ?";
    private static final String PESQUISAR = "SELECT * FROM treinosClientes";
    private static final String PESQUISAR_ID_FUNCIONARIO = "SELECT * FROM treinosClientes WHERE funcionario_id = ? ";

    public TreinoClienteDAO(Connection conn) {
        super(conn);
    }

    public void inserir(TreinoCliente treinoCliente) throws Exception {
        try {
            psmt = conn.prepareStatement(INSERIR, PreparedStatement.RETURN_GENERATED_KEYS);

           psmt.setInt(1, treinoCliente.getIdCliente());
           psmt.setInt(2, treinoCliente.getIdTreino());
           psmt.setInt(3, treinoCliente.getIdFuncionario());
           psmt.setDate(4, java.sql.Date.valueOf(treinoCliente.getDataInicio()));
           psmt.setDate(5, java.sql.Date.valueOf(treinoCliente.getDataFinal()));

            int res = psmt.executeUpdate();

            if (res == 1) {
                rs = psmt.getGeneratedKeys();
                rs.next();
                treinoCliente.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir TreinoCliente: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, rs);
        }
    }

    public void atualizar(TreinoCliente treinoCliente) throws Exception {
        try {
            psmt = conn.prepareStatement(ATUALIZAR);
            psmt.setInt(1, treinoCliente.getIdCliente());
            psmt.setInt(2, treinoCliente.getIdTreino());
            psmt.setInt(3, treinoCliente.getIdFuncionario());
            psmt.setDate(4, java.sql.Date.valueOf(treinoCliente.getDataInicio()));
            psmt.setDate(5, java.sql.Date.valueOf(treinoCliente.getDataFinal()));
            psmt.setInt(6, treinoCliente.getId());

            psmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar TreinoCliente: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, null);
        }
    }

    public void excluir(TreinoCliente treinoCliente) throws Exception {
        try {
            psmt = conn.prepareStatement(EXCLUIR);
            psmt.setInt(1, treinoCliente.getId());

            psmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao excluir TreinoCliente: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, null);
        }
    }

    public List<TreinoCliente> listar() {
        List<TreinoCliente> lista = new ArrayList<TreinoCliente>();
        try {
            psmt = conn.prepareStatement(PESQUISAR);
            rs = psmt.executeQuery();

            while (rs.next()) {
         TreinoCliente treinoCliente = new TreinoCliente();

            treinoCliente.setId(rs.getInt(1));
            treinoCliente.setIdCliente(rs.getInt(2));
            treinoCliente.setIdTreino(rs.getInt(3));
            treinoCliente.setIdFuncionario(rs.getInt(4));
            treinoCliente.setDataInicio(rs.getDate(5).toLocalDate());
            treinoCliente.setDataFinal(rs.getDate(6).toLocalDate());

            lista.add(treinoCliente);
        }
        } catch (SQLException e) {
            System.out.println("Não foi possível realizar a listagem dos treinoClientes.");
        } finally {
            fecharRecursos(null, psmt, rs);
        }
        return lista;
    }

    public List<TreinoCliente> pesquisarPorIdFuncionario(int idFuncionario) {
        List<TreinoCliente> lista = new ArrayList<TreinoCliente>();
        try {
            psmt = conn.prepareStatement(PESQUISAR_ID_FUNCIONARIO);
            psmt.setInt(1, idFuncionario);
            rs = psmt.executeQuery();

            while (rs.next()) {
         TreinoCliente treinoCliente = new TreinoCliente();

            treinoCliente.setId(rs.getInt(1));
            treinoCliente.setIdCliente(rs.getInt(2));
            treinoCliente.setIdTreino(rs.getInt(3));
            treinoCliente.setIdFuncionario(rs.getInt(4));
            treinoCliente.setDataInicio(rs.getDate(5).toLocalDate());
            treinoCliente.setDataFinal(rs.getDate(6).toLocalDate());

            lista.add(treinoCliente);
        }
        } catch (SQLException e) {
            System.out.println("Não foi possível realizar a busca dos treinoClientes por id funcionar.");
        } finally {
            fecharRecursos(null, psmt, rs);
        }
        return lista;
    }
}
