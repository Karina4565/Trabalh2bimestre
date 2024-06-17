package com.trabalho2bimestre.modelo;


import java.time.LocalDate;

public class TreinoCliente {

    public TreinoCliente(int idCliente, int idTreino, int idFuncionario) {
        this.idCliente = idCliente;
        this.idTreino = idTreino;
        this.idFuncionario = idFuncionario;
        this.dataInicio = LocalDate.now();
        this.dataFinal = dataInicio.plusMonths(1);
        
    }
    
    public TreinoCliente(){
    }
    
    private int id;
    private int idCliente;
    private int idTreino;
    private int idFuncionario;
    private LocalDate dataInicio;
    private LocalDate dataFinal;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(int idTreino) {
        this.idTreino = idTreino;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }
    

  
    
}
