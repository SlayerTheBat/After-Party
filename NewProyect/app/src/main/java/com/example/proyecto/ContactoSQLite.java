package com.example.proyecto;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ContactoSQLite extends SQLiteOpenHelper {

    public ContactoSQLite(Context context) {
        super(context, "Hola", null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contacto (Correod String primary key, Telefono String, Comentario String);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void crearComentario(ContactoDatos contacto){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO contacto (Correod, Telefono, Comentario) VALUES ('"+ contacto.getCorreo() +"', '"+contacto.getTelefono()+"', '"+contacto.getComentario()+"');");
        db.close();
    }



}