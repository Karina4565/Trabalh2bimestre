
package com.trabalho2bimestre.teste;

import com.trabalho2bimestre.conexao.FabricaConexao;
import java.sql.Connection;

public class TesteConexao {
    
    public static void teste(){
        try {
            Connection conn = FabricaConexao.getConnectionPostgre();
            System.out.println("Conectou!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
