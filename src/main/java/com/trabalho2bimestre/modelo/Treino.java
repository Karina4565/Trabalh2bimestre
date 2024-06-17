
package com.trabalho2bimestre.modelo;

public class Treino {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Treino(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public Treino() {
      
    }
    
      
    private String nome;
    
    private String descricao;
    
    private int id;

   
    
    
}

