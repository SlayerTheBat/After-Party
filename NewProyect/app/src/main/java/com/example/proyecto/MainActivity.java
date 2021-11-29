package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CuentaSQLite DB ;
    Button btnOtra, btnOtra1;
    private EditText nombre;
    private EditText contraseña;
    CuentaSQLite sqLite=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        btnOtra = findViewById(R.id.button);
        nombre= (EditText)findViewById(R.id.TextNombre);
        contraseña=(EditText)findViewById(R.id.TextContraseña);
        btnOtra1 = findViewById(R.id.button3);
        DB = new CuentaSQLite(this);
        btnOtra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String Nombre = nombre.getText().toString();
                String Contraseña = contraseña.getText().toString();
                if(Nombre.equals("")||contraseña.equals("")){
                    Toast.makeText(MainActivity.this, "Inserte datos", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean ver = DB.registro(Nombre, Contraseña);
                    if(ver==true){
                        Toast.makeText(MainActivity.this, "Inicio Sesion Exitoso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( MainActivity.this, Registro.class);

                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();
                    }}
            }

        });
        btnOtra1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent( MainActivity.this, Registro.class);

                startActivity(intent);
            }
        });


    }


}