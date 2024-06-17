package com.trabalho2bimestre.teste;

import com.trabalho2bimestre.controle.servico.TreinoServico;
import com.trabalho2bimestre.modelo.Treino;
import java.util.List;

public class TreinoTeste {
    
    public static void teste() throws Exception {
         //inserir();
         //atualizar();
         //excluir();
         //todos();
    }
    
    public static void inserir() throws Exception {
        Treino treino = new Treino("Agachamento sumo", "Perna");
        TreinoServico.inserirTreino(treino);
    }
    
    public static void atualizar() throws Exception {
        Treino treino = new Treino("Agachamento sumo", "teste");
        treino.setId(4);
        TreinoServico.atualizarTreino(treino);
    }
    
    public static void excluir() throws Exception {
        Treino treino = new Treino();
        treino.setId(4);
        TreinoServico.excluirTreino(treino);
    }
    
    public static void todos() throws Exception {
        List<Treino> treinos = TreinoServico.todasTreinos();
        
        for (Treino p : treinos) {
            System.out.println("ID: " + p.getId() + 
                               ", Nome: " + p.getNome() +
                               ", Descricao: " + p.getDescricao());
        }
    }
}
