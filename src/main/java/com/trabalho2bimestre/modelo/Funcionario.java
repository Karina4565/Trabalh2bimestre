
package com.trabalho2bimestre.modelo;


public class Funcionario {

    public Funcionario(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    
    private String nome;
    
    private  String email;
    
    private String telefone;
    
    private int id;

    public Funcionario() {}
        

   

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    


    
}
