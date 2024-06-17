
package com.trabalho2bimestre.modelo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Cliente {
    
    private String nome;
    
    private String telefone; 
            
    private String email;
    
    private Integer id;
    
    private String altura;
    
    //private String peso;
    
    private String genero;
    
    private LocalDate dataNascimento;

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    

    public Cliente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    private List<Treino> treinos = new ArrayList<>();


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    
    public void addTreino(Treino treino) {
        treinos.add(treino);
    }
 
    public List<Treino> getTreinos(){
        return treinos;
    }
            
    public boolean removeTreino(Treino treino) {
        return treinos.remove(treino);
    }
    
    

    public void getId(char c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Cliente(String nome, String email, LocalDate dataNascimento, String genero, String altura, String telefone) {
    this.nome = nome;
    this.email = email;
    this.dataNascimento = dataNascimento;
    this.genero = genero;
    this.altura = altura;
    this.telefone = telefone;
}

    
    
    
}

