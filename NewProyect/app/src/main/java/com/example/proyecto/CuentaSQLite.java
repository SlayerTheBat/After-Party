package com.example.proyecto;

import android.content.ContentValues;
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
    public Boolean insertData(String nombre, String contraseña, String correo, String edad, String vcontraseña){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Nombre", nombre);
        cv.put("Contraseña", contraseña);
        cv.put("Correo", correo);
        cv.put("Edad", edad);
        cv.put("VContraseña", vcontraseña);
        long result = db.insert("users",null,cv);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean ver(String nombre){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from cuenta where Nombre = ?", new String[]{nombre});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean registro(String nombre, String contraseña){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from cuenta where nombre = ? and contraseña = ?", new String[] {nombre,contraseña});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
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
