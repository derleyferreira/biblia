package com.example.biblia.entity;

import android.media.Image;

import java.util.Date;

public class Perfil {

    private int pKPerfil;
    private String nome;
    private String igreja;
    private String nomePastor;
    private Date dataBatismo;
    private Image foto;

    public int getPK_PERFIL() {
        return pKPerfil;
    }

    public void setPK_PERFIL(int PK_PERFIL) {
        this.pKPerfil = PK_PERFIL;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIgreja() {
        return igreja;
    }

    public void setIgreja(String igreja) {
        this.igreja = igreja;
    }

    public String getNomePastor() {
        return nomePastor;
    }

    public void setNomePastor(String nomePastor) {
        this.nomePastor = nomePastor;
    }

    public Date getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(Date dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }
}
