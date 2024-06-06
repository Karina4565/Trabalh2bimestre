
package com.trabalho2bimestre.teste;

import com.trabalho2bimestre.controle.servico.ClienteServico;
import com.trabalho2bimestre.modelo.Cliente;
import java.time.LocalDate;
import java.util.List;

public class ClienteTeste {
    
    public static void teste() throws Exception {

      //inserir();
          atualizar();
       // excluir();
       // todos();
 
    }
    
    
    public static void inserir() throws Exception {
    Cliente cliente = new Cliente("Julia", "teste@gmail.com", LocalDate.of(2020, 2, 17), "F", "1,0", "44988089777");

        ClienteServico.inserirCliente(cliente);
    
    }
    
    public static void atualizar() throws Exception {
         Cliente cliente = new Cliente("Julia", "teste@gmail.com", LocalDate.of(2020, 2, 17), "I", "1,0", "44988089777");

          cliente.setId(1);
    
        
        ClienteServico.atualizarCliente(cliente);
     
    
    }
    
     public static void excluir() throws Exception {
         Cliente cliente = new Cliente();
          cliente.setId(4);
    
      ClienteServico.excluirCliente(cliente);
   
    }
    
     public static void todos() throws Exception{
         ClienteServico.todasClientes();
         
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


    
    

