package com.trabalho2bimestre.controle.DAO;

import com.trabalho2bimestre.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAOAbstrato {

    private static final String INSERIR = "INSERT INTO cliente"
            + "(nome, email, data_nascimento, genero, altura, telefone) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String ATUALIZAR = "UPDATE cliente SET "
        + "nome = ?, "
        + "email = ?, "
        + "data_nascimento = ?, " 
        + "genero = ?, "
        + "altura = ?, "
        + "telefone = ? "
        + "WHERE id = ?";


    private static final String EXCLUIR = "DELETE FROM cliente WHERE id = ?";
    private static final String PESQUISAR = "SELECT * FROM cliente";

    public ClienteDAO(Connection conn) {
        super(conn);
    }

    public void inserir(Cliente cliente) throws Exception {
        try {
            psmt = conn.prepareStatement(INSERIR, PreparedStatement.RETURN_GENERATED_KEYS);

            psmt.setString(1, cliente.getNome());
            psmt.setString(2, cliente.getEmail());
            psmt.setDate(3, java.sql.Date.valueOf(cliente.getDataNascimento()));
            psmt.setString(4, cliente.getGenero());
            psmt.setString(5, cliente.getAltura());
            psmt.setString(6, cliente.getTelefone());

            int res = psmt.executeUpdate();

            if (res == 1) {
                rs = psmt.getGeneratedKeys();
                rs.next();
                cliente.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Cliente: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, rs);
        }
    }

    public void atualizar(Cliente cliente) throws Exception {
        try {
            psmt = conn.prepareStatement(ATUALIZAR);
            psmt.setString(1, cliente.getNome());
            psmt.setString(2, cliente.getEmail());
            psmt.setDate(3, java.sql.Date.valueOf(cliente.getDataNascimento()));
            psmt.setString(4, cliente.getGenero());
            psmt.setString(5, cliente.getAltura());
            psmt.setString(6, cliente.getTelefone());
            psmt.setInt(7, cliente.getId());

            psmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Cliente: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, null);
        }
    }

    public void excluir(Cliente cliente) throws Exception {
        try {
            psmt = conn.prepareStatement(EXCLUIR);
            psmt.setInt(1, cliente.getId());

            psmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao excluir Cliente: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, null);
        }
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<Cliente>();
        try {
            psmt = conn.prepareStatement(PESQUISAR);
            rs = psmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setEmail(rs.getString(3));
                cliente.setDataNascimento(rs.getDate(4) != null ? rs.getDate(4).toLocalDate() : null);
                cliente.setGenero(rs.getString(5));
                cliente.setAltura(rs.getString(6));
                cliente.setTelefone(rs.getString(7));

                lista.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível realizar a listagem dos clientes.");
        } finally {
            fecharRecursos(null, psmt, rs);
        }
        return lista;
    }
}
