package com.trabalho2bimestre.controle.servico;

import com.trabalho2bimestre.conexao.FabricaConexao;
import com.trabalho2bimestre.controle.DAO.ClienteDAO;
import com.trabalho2bimestre.controle.DAO.DAOAbstrato;
import com.trabalho2bimestre.modelo.Cliente;
import java.sql.Connection;
import java.util.List;

public class ClienteServico {

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

    public static void inserirCliente(Cliente cliente) throws Exception {
        if (!validarCampos(cliente)) {
            return;
        }

        Connection conn = abrirConexaoBD();
        ClienteDAO clienteDAO = new ClienteDAO(conn);

        clienteDAO.inserir(cliente);

        fecharConexaoBD(conn);
    }

    public static void atualizarCliente(Cliente cliente) throws Exception {
        if (!validarCampos(cliente)) {
            return;
        }

        Connection conn = abrirConexaoBD();
        ClienteDAO clienteDAO = new ClienteDAO(conn);

        clienteDAO.atualizar(cliente);

        fecharConexaoBD(conn);
    }

    private static boolean validarCampos(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty() || cliente.getNome().length() > 100) {
            System.out.println("Erro: Nome não pode ser vazio e deve ter no máximo 100 caracteres.");
            return false;
        }

        if (cliente.getEmail() == null || cliente.getEmail().isEmpty() || cliente.getEmail().length() > 100) {
            System.out.println("Erro: Email não pode ser vazio e deve ter no máximo 100 caracteres.");
            return false;
        }

        if (cliente.getAltura() == null || cliente.getAltura().isEmpty() || cliente.getAltura().length() > 4) {
            System.out.println("Erro: Altura não pode ser vazio e deve ter no máximo 4 caracteres.");
            return false;
        }

        if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty() || cliente.getTelefone().length() > 15) {
            System.out.println("Erro: Telefone não pode ser vazio e deve ter no máximo 15 caracteres.");
            return false;
        }

        if (!"M".equals(cliente.getGenero()) && !"F".equals(cliente.getGenero()) && !"I".equals(cliente.getGenero())) {
            System.out.println("Erro: Gênero inválido. Deve ser 'M', 'F' ou 'I'.");
            return false;
        }

        return true;
    }

    public static void excluirCliente(Cliente cliente) throws Exception {
        Connection conn = abrirConexaoBD();
        ClienteDAO clienteDAO = new ClienteDAO(conn);
        clienteDAO.excluir(cliente);
        fecharConexaoBD(conn);
    }

    public static List<Cliente> todasClientes() {
        Connection conn = null;
        List<Cliente> clientes = null;

        try {
            conn = abrirConexaoBD();
            ClienteDAO clienteDAO = new ClienteDAO(conn);
            clientes = clienteDAO.listar();
            fecharConexaoBD(conn);
        } catch (Exception e) {
            
        } finally {
            if (conn != null) {
                fecharConexaoBD(conn);
            }
        }

        return clientes;
    }
}
