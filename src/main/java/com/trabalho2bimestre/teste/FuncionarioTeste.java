package com.trabalho2bimestre.teste;

import com.trabalho2bimestre.controle.servico.FuncionarioServico;
import com.trabalho2bimestre.modelo.Funcionario;
import java.util.List;

public class FuncionarioTeste {
    
    public static void teste() throws Exception {
        // inserir();
        // atualizar();
         excluir();
         //todos();
    }
    
    public static void inserir() throws Exception {
        Funcionario funcionario = new Funcionario("Karina", "silva@gmail.com", "555");
        FuncionarioServico.inserirFuncionario(funcionario);
    }
    
    public static void atualizar() throws Exception {
        Funcionario funcionario = new Funcionario("Tatiane", "silva@gmail.com", "44988568936");
        funcionario.setId(4);
        FuncionarioServico.atualizarFuncionario(funcionario);
    }
    
    public static void excluir() throws Exception {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1);
        FuncionarioServico.excluirFuncionario(funcionario);
    }
    
    public static void todos() throws Exception {
        List<Funcionario> funcionarios = FuncionarioServico.todasFuncionarios();
        
        for (Funcionario p : funcionarios) {
            System.out.println("ID: " + p.getId() + 
                               ", Nome: " + p.getNome() +
                               ", Email: " + p.getEmail() +
                               ", Telefone: " + p.getTelefone());
        }
    }
}
