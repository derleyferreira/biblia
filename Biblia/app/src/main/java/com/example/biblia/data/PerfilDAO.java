package com.example.biblia.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.biblia.entity.Perfil;

public class PerfilDAO {

    private Conexao conexao;
    private SQLiteDatabase db;


    public PerfilDAO(Context context) {

        conexao = new Conexao(context);
        conexao.openDataBase();
        db = conexao.getWritableDatabase();
    }

    public void editarPerfil(Perfil perfil){

    }

}
