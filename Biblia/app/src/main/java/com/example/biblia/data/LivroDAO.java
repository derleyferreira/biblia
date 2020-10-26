package com.example.biblia.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.biblia.entity.Livros;

import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private Conexao conexao;
    private SQLiteDatabase bd;

    public LivroDAO(Context context) {
        conexao = new Conexao(context);
        conexao.openDataBase();
        bd = conexao.getReadableDatabase();
    }

    public List<Livros> retornaLivros(){



        List<Livros> livros = new ArrayList<>();

        try {
            String sql = "SELECT * FROM LIVRO";
            Cursor cursor = bd.rawQuery(sql,null);

        while (cursor.moveToNext()){
            Livros l = new Livros();

            l.setPK(cursor.getInt(0));
            l.setTestamento(1);
            l.setNumero(cursor.getInt(2));
            l.setNome(cursor.getString(3));

            livros.add(l);
        }
        }catch (Exception erro){
            System.out.println(erro.getMessage());
        }

        return livros;

    }
}
