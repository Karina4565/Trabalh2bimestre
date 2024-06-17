package com.trabalho2bimestre.controle.servico;

import com.trabalho2bimestre.conexao.FabricaConexao;
import com.trabalho2bimestre.controle.DAO.FuncionarioDAO;
import com.trabalho2bimestre.controle.DAO.DAOAbstrato;
import com.trabalho2bimestre.controle.DAO.TreinoClienteDAO;
import com.trabalho2bimestre.modelo.Funcionario;
import com.trabalho2bimestre.modelo.TreinoCliente;
import java.sql.Connection;
import java.util.List;

public class FuncionarioServico {

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

    public static void inserirFuncionario(Funcionario funcionario) throws Exception {
        if (!validarCampos(funcionario)) {
            return;
        }

        Connection conn = abrirConexaoBD();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conn);

        funcionarioDAO.inserir(funcionario);

        fecharConexaoBD(conn);
    }

    public static void atualizarFuncionario(Funcionario funcionario) throws Exception {
        if (!validarCampos(funcionario)) {
            return;
        }

        Connection conn = abrirConexaoBD();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conn);

        funcionarioDAO.atualizar(funcionario);

        fecharConexaoBD(conn);
    }

    private static boolean validarCampos(Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().isEmpty() || funcionario.getNome().length() > 100) {
            System.out.println("Erro: Nome não pode ser vazio e deve ter no máximo 100 caracteres.");
            return false;
        }

        if (funcionario.getEmail() == null || funcionario.getEmail().isEmpty() || funcionario.getEmail().length() > 100) {
            System.out.println("Erro: Email não pode ser vazio e deve ter no máximo 100 caracteres.");
            return false;
        }

        if (funcionario.getTelefone() == null || funcionario.getTelefone().isEmpty() || funcionario.getTelefone().length() > 15) {
            System.out.println("Erro: Telefone não pode ser vazio e deve ter no máximo 15 caracteres.");
            return false;
        }

     

        return true;
    }

    public static void excluirFuncionario(Funcionario funcionario) throws Exception {
        Connection conn = abrirConexaoBD();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conn);
        
        if(podeExcluir(conn, funcionario.getId())){
            funcionarioDAO.excluir(funcionario);
        } else {
             System.out.println("Não foi possível excluir o funcionario!.");
        }
        fecharConexaoBD(conn);
    }
    
    private static boolean podeExcluir(Connection conn, int idFuncionario) {
        TreinoClienteDAO funcionarioDAO = new TreinoClienteDAO(conn);
        List<TreinoCliente> treinos = funcionarioDAO.pesquisarPorIdFuncionario(idFuncionario);
        return treinos.isEmpty();
    }

    public static List<Funcionario> todasFuncionarios() {
        Connection conn = null;
        List<Funcionario> funcionarios = null;

        try {
            conn = abrirConexaoBD();
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conn);
            funcionarios = funcionarioDAO.listar();
            fecharConexaoBD(conn);
        } catch (Exception e) {
            System.out.println("Não foi possível listar os funcionarios.");
        } finally {
            if (conn != null) {
                fecharConexaoBD(conn);
            }
        }

        return funcionarios;
    }
}
