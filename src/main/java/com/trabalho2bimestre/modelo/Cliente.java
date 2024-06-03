
package com.trabalho2bimestre.modelo;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Cliente {

    
    
    private String nome;
    
    private String telefone; 
            
    private String email;
    
    private Integer id;
    
    private String altura;
    
    private String peso;
    
    private String genero;
    

    public Cliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
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
    
    public Cliente(String nome, String telefone, String email, String altura, String peso, String genero) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
    }

    public void getId(char c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

