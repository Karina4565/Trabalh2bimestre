
package com.trabalho2bimestre.app;

import com.trabalho2bimestre.teste.ClienteTeste;
import com.trabalho2bimestre.teste.TesteConexao;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aplicacao {
    public static void main(String[] args) {
        try {
            
            //TesteConexao.teste();
            ClienteTeste.teste();
            
        } catch (Exception ex) {
            System.out.println("ERRO: " + ex.getMessage());
            Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}