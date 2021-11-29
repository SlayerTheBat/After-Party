package com.example.proyecto;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CuentaSQLite extends SQLiteOpenHelper  {
    public CuentaSQLite(Context context) {
        super(context, "EJEMPLO", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE cuenta (Nombre String PRIMARY KEY, Contraseña String, Correo String, Edad String, VContraseña String);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void crearCuenta(Cuenta cuenta){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO Cuenta (nombre, contraseña, correo, edad, vcontraseña) VALUES ('"+ cuenta.getNombre() +"', '"+cuenta.getContraseña()+"', '"+cuenta.getCorreo()+"','"+cuenta.getEdad()+"','"+cuenta.getVcontraseña()+"');");
        db.close();
    }
    public void inicioSesion(Cuenta cuenta){
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL("SELECT * FROM Cuenta WHERE Contraseña ='"+cuenta.getContraseña()+"');");
        db.close();
    }
}
