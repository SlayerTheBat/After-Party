package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
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
        sqLite = new CuentaSQLite(this);
        btnOtra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validate(nombre.getText().toString(), contraseña.getText().toString());
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

    private void validate(String nombre, String contraseña) {
        if((nombre.equals("vicente")) && (contraseña.equals("vicente"))){
            Intent intent = new Intent(MainActivity.this, Menu.class);
            startActivity(intent);
        }else{

        }
    }
}