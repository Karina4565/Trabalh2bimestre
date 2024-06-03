
package com.trabalho2bimestre.teste;

import com.trabalho2bimestre.controle.servico.ClienteServico;
import com.trabalho2bimestre.modelo.Cliente;
import java.util.List;

public class ClienteTeste {
    
    public static void teste() throws Exception {

//        inserir();
        atualizar();
//        excluir()
//        todos();
 
    }
    
    public static void atualizar() throws Exception {
         Cliente cliente = new Cliente("Felipe", "999", "email", "1,90", "80", "M");
          cliente.setId(10);
    
        
        ClienteServico.atualizarCliente(cliente);
     
    
    }
    
}


    
    

