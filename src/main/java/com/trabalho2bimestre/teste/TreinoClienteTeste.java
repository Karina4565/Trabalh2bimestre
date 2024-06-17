package com.trabalho2bimestre.teste;

import com.trabalho2bimestre.controle.servico.TreinoClienteServico;
import com.trabalho2bimestre.modelo.TreinoCliente;
import java.util.List;

public class TreinoClienteTeste {
    
    public static void teste() throws Exception {
        // inserir();
        // atualizar();
         //excluir();
         //todos();
    }
    
    public static void inserir() throws Exception {
        TreinoCliente treinoCliente = new TreinoCliente();
        TreinoClienteServico.inserirTreinoCliente(treinoCliente);
    }
    
    public static void atualizar() throws Exception {
        TreinoCliente treinoCliente = new TreinoCliente();
        treinoCliente.setId(4);
        TreinoClienteServico.atualizarTreinoCliente(treinoCliente);
    }
    
    public static void excluir() throws Exception {
        TreinoCliente treinoCliente = new TreinoCliente();
        treinoCliente.setId(1);
        TreinoClienteServico.excluirTreinoCliente(treinoCliente);
    }
    
    public static void todos() throws Exception {
        List<TreinoCliente> treinoClientes = TreinoClienteServico.todasTreinoClientes();
        
        for (TreinoCliente p : treinoClientes) {
            System.out.println("ID: " + p.getId() + 
                               ", getIdCliente: " + p.getIdCliente()+
                               ", getIdTreino: " + p.getIdTreino()+
                               ", getIdFuncionario: " + p.getIdFuncionario());
                               
        }
    }
}
