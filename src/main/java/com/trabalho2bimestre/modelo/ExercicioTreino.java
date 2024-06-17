
package com.trabalho2bimestre.modelo;

public class ExercicioTreino {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(int idTreino) {
        this.idTreino = idTreino;
    }

    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public ExercicioTreino(int idTreino, int idExercicio, int series, int repeticoes, String observacoes) {
        this.idTreino = idTreino;
        this.idExercicio = idExercicio;
        this.series = series;
        this.repeticoes = repeticoes;
        this.observacoes = observacoes;
    }
    
    public ExercicioTreino() {
     
    }
    
    private int id;
    private int idTreino;
    private int idExercicio;
    private int series;
    private int repeticoes;
    private String observacoes;
    
    
    
    
}
