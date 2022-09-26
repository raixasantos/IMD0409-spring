package com.jeanlima.mvcapp.model;

public class Curso {
    private int id;
    private String nome;

    public Curso(){

    }

    public Curso(String nome){
        this.nome = nome;
    }
    
    public Curso(String nome, int id){
        this.nome = nome;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
