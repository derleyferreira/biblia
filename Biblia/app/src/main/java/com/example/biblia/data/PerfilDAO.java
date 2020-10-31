package com.example.biblia.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public Perfil retornaPerfil(){

        Perfil perfil = null;

        Cursor cursor = db.rawQuery("SELECT * FROM PERFIL",null);
        if (cursor.moveToNext()){
           perfil = new Perfil();

           perfil.setPK_PERFIL(cursor.getInt(cursor.getColumnIndex("PK_PERFIL")));
           perfil.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
           perfil.setNomePastor(cursor.getString(cursor.getColumnIndex("NOME_PASTOR")));
           perfil.setIgreja(cursor.getString(cursor.getColumnIndex("IGREJA")));

        }

        return perfil;
    }

    public void editarPerfil(Perfil perfil){

        ContentValues data = new ContentValues();

        data.put("NOME", perfil.getNome());
        data.put("IGREJA", perfil.getIgreja());
        data.put("NOME_PASTOR",perfil.getNomePastor());
//        data.put("DATA_BATISMO", String.valueOf(perfil.getDataBatismo()));

        try{
            db.update("PERFIL", data, "PK_PERFIL = 1",null);
        }catch (Exception erro){
            String a = erro.getMessage();
            erro.printStackTrace();
        }



    }

}
