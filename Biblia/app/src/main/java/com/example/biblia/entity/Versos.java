package com.example.biblia.entity;

public class Versos {
    private int PK_Verso;
    private int livro_fk;
    private int capitulo;
    private int numeroVerso;

    public int getNumeroVerso() {
        return numeroVerso;
    }

    public void setNumeroVerso(int numeroVerso) {
        this.numeroVerso = numeroVerso;
    }

    private String verso;

    public int getPK_Verso() {
        return PK_Verso;
    }

    public void setPK_Verso(int PK_Verso) {
        this.PK_Verso = PK_Verso;
    }

    public int getLivro_fk() {
        return livro_fk;
    }

    public void setLivro_fk(int livro_fk) {
        this.livro_fk = livro_fk;
    }

    public int getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(int capitulo) {
        this.capitulo = capitulo;
    }

    public String getVerso() {
        return verso;
    }

    public void setVerso(String verso) {
        this.verso = verso;
    }
}
