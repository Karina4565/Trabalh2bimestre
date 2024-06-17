package com.trabalho2bimestre.teste;

import com.trabalho2bimestre.controle.servico.ExercicioServico;
import com.trabalho2bimestre.modelo.Exercicio;
import java.util.List;

public class ExercicioTeste {
    
    public static void teste() throws Exception {
         //inserir();
         //atualizar();
         //excluir();
         //todos();
    }
    
    public static void inserir() throws Exception {
        Exercicio exercicio = new Exercicio("Agachamento sumo", "Perna");
        ExercicioServico.inserirExercicio(exercicio);
    }
    
    public static void atualizar() throws Exception {
        Exercicio exercicio = new Exercicio("Agachamento sumo", "Atualização");
        exercicio.setId(6);
        ExercicioServico.atualizarExercicio(exercicio);
    }
    
    public static void excluir() throws Exception {
        Exercicio exercicio = new Exercicio();
        exercicio.setId(6);
        ExercicioServico.excluirExercicio(exercicio);
    }
    
    public static void todos() throws Exception {
        List<Exercicio> exercicios = ExercicioServico.todasExercicios();
        
        for (Exercicio p : exercicios) {
            System.out.println("ID: " + p.getId() + 
                               ", Nome: " + p.getNome() +
                               ", Descricao: " + p.getDescricao());
        }
    }
}
