package com.trabalho2bimestre.app;

import com.trabalho2bimestre.teste.ClienteTeste;
import com.trabalho2bimestre.teste.ExercicioTeste;
import com.trabalho2bimestre.teste.ExercicioTreinoTeste;
import com.trabalho2bimestre.teste.FuncionarioTeste;
import com.trabalho2bimestre.teste.TesteConexao;
import com.trabalho2bimestre.teste.TreinoTeste;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aplicacao {
    public static void main(String[] args) {
        try {
            //TesteConexao.teste();
            //ClienteTeste.teste();
            //FuncionarioTeste.teste();
            //TreinoClienteTeste.teste();
            //ExercicioTeste.teste();
            //TreinoTeste.teste();
            ExercicioTreinoTeste.teste();
        } catch (Exception ex) {
        
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
