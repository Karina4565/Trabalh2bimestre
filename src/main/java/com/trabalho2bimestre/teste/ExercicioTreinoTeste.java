
package com.trabalho2bimestre.teste;

import com.trabalho2bimestre.controle.servico.ExercicioTreinoServico;
import com.trabalho2bimestre.modelo.ExercicioTreino;
import java.time.LocalDate;
import java.util.List;

public class ExercicioTreinoTeste {
    
    public static void teste() throws Exception {

      inserir();
          //atualizar();
       // excluir();
        todos();
 
    }
    
    
    public static void inserir() throws Exception {
        ExercicioTreino exercicioTreino = new ExercicioTreino(1, 1, 3, 10, "Treino perna");
            
        ExercicioTreinoServico.inserirExercicioTreino(exercicioTreino);
    
    }
    
    public static void atualizar() throws Exception {
    ExercicioTreino exercicioTreino = new ExercicioTreino();

          exercicioTreino.setId(1);
    
        
        ExercicioTreinoServico.atualizarExercicioTreino(exercicioTreino);
     
    
    }
    
     public static void excluir() throws Exception {
         ExercicioTreino exercicioTreino = new ExercicioTreino();
          exercicioTreino.setId(4);
    
      ExercicioTreinoServico.excluirExercicioTreino(exercicioTreino);
   
    }
    
     public static void todos() throws Exception{
         ExercicioTreinoServico.todasExercicioTreinos();
         
        List<ExercicioTreino> exercicioTreinos = ExercicioTreinoServico.todasExercicioTreinos();
        
        for (ExercicioTreino p : exercicioTreinos){
           System.out.println("ID: " + p.getId() +
                               ", Treino ID: " + p.getIdTreino() +
                               ", Exercicio ID: " + p.getIdExercicio() +
                               ", Séries: " + p.getSeries() +
                               ", Repetições: " + p.getRepeticoes() +
                               ", Observações: " + p.getObservacoes());
        }
     }
    
    
}


    
    

