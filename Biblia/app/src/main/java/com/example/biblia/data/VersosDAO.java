package com.example.biblia.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.biblia.entity.Livros;
import com.example.biblia.entity.Versos;

import java.util.ArrayList;
import java.util.List;

public class VersosDAO {
    private Conexao conexao;
    private SQLiteDatabase bd;

    public VersosDAO(Context context){
        conexao = new Conexao(context);
        bd = conexao.getReadableDatabase();
    }

    public List<Versos> retornaVersos(int pLivro){
        List<Versos> versos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM VERSOS WHERE LIVRO_FK = " + pLivro;
            Cursor cursor = bd.rawQuery(sql,null);

            while (cursor.moveToNext()){
                Versos v = new Versos();
                v.setPK_Verso(cursor.getInt(0));
                v.setCapitulo(cursor.getInt(2));
                v.setLivro_fk(cursor.getInt(1));
                v.setNumeroVerso(cursor.getInt(3));
                v.setVerso(cursor.getString(4));

                versos.add(v);
            }
        }catch (Exception erro){
            System.out.println(erro.getMessage());
        }

        return  versos;
    }

    public List<Versos> retornaVersos(int pLivro, int pCapitulo){
        List<Versos> versos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM VERSOS WHERE LIVRO_FK = " + pLivro +  " and CAPITULO = " + pCapitulo;
            Cursor cursor = bd.rawQuery(sql,null);

            while (cursor.moveToNext()){
                Versos v = new Versos();
                v.setPK_Verso(cursor.getInt(0));
                v.setCapitulo(cursor.getInt(2));
                v.setLivro_fk(cursor.getInt(1));
                v.setNumeroVerso(cursor.getInt(3));
                v.setVerso(cursor.getString(4));

                versos.add(v);
            }
        }catch (Exception erro){
            System.out.println(erro.getMessage());
        }

        return  versos;
    }

}
