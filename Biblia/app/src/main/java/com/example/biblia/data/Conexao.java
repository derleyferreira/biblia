package com.example.biblia.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    public static final String nomeBD = "bdbiblia";
    public static final int version   = 1;
    public static final String pathDB = "/data/data/com.example.biblia/databases/";
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public Conexao(Context context) {
        super(context, nomeBD, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDataBase(){
       String dbPath = context.getDatabasePath(nomeBD).getPath();
       if (sqLiteDatabase != null && sqLiteDatabase.isOpen()){
           return;
       }

       sqLiteDatabase = SQLiteDatabase.openDatabase(dbPath,null,SQLiteDatabase.OPEN_READWRITE);

    }

    public void closeDataBase(){
        if (sqLiteDatabase != null){
            sqLiteDatabase.close();
        }
    }

}
