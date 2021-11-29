package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {
    Button btnOtra;
    private EditText nombre;
    private EditText edad;
    private EditText correo;
    private EditText contraseña;
    private EditText vcontraseña;
    CuentaSQLite sqLite=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btnOtra = findViewById(R.id.buttonreg);
        nombre= (EditText)findViewById(R.id.TextNombre);
        contraseña= (EditText)findViewById(R.id.TextContraseña);
        correo= (EditText)findViewById(R.id.TextCorreo);
        edad= findViewById(R.id.TextEdad);
        vcontraseña= (EditText) findViewById(R.id.TextVContraseña);
        sqLite= new CuentaSQLite(this);
        btnOtra.setOnClickListener(new View.OnClickListener()
        {


            public void onClick(View view){
                Cuenta cu= new Cuenta();
                cu.setNombre(nombre.getText().toString());
                cu.setContraseña(contraseña.getText().toString());
                cu.setCorreo(correo.getText().toString());
                cu.setEdad(edad.getText().toString());
                cu.setVcontraseña(vcontraseña.getText().toString());
                sqLite.crearCuenta(cu);
                Intent intent = new Intent( Registro.this, Menu.class);
                startActivity(intent);
            }

        });
    }
}