
package com.trabalho2bimestre.teste;

import com.trabalho2bimestre.controle.servico.ClienteServico;
import com.trabalho2bimestre.modelo.Cliente;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteTeste {
    
    public static void teste() throws Exception {

     // inserir();
          //atualizar();
       // excluir();
       // todos();
 
    }
    
    
    public static void inserir() throws Exception {
    Cliente cliente = new Cliente("Maria", "1teste@gmail.com", LocalDate.of(2020, 2, 17), "F", "1,0", "441988089777");

        ClienteServico.inserirCliente(cliente);
    
    }
    
    public static void atualizar() throws Exception {
        Cliente cliente = new Cliente("Larissa", "teste@gmail.com", LocalDate.of(2020, 2, 17), "F","1,0", "44988089");

          cliente.setId(1);
    
        
        ClienteServico.atualizarCliente(cliente);
     
    
    }
    
     public static void excluir() throws Exception {
         Cliente cliente = new Cliente();
          cliente.setId(4);
    
      ClienteServico.excluirCliente(cliente);
   
    }
    
     public static void todos() throws Exception{
        try {
            ClienteServico.todasClientes();
        } catch (Exception ex) {
            Logger.getLogger(ClienteTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        List<Cliente> clientes = ClienteServico.todasClientes();
        
        for (Cliente p : clientes){
           System.out.println("ID: " + p.getId() + 
                                   ", Nome: " + p.getNome() +
                                   ", Email: " + p.getEmail() +
                                   ", Gênero: " + p.getGenero() +
                                   ", Altura: " + p.getAltura() +
                                   ", Telefone: " + p.getTelefone()+
                                   ", Data de Nascimento: " + p.getDataNascimento());
            }
     }
    
    
}


    
    

