package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opciones extends AppCompatActivity {
    Button btnOtra, btnotra1, btnotra2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        btnOtra = findViewById(R.id.buttonC);
        btnotra1 = findViewById(R.id.buttonR);
        btnotra2 = findViewById(R.id.buttoncr);
        btnOtra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent( Opciones.this, Contacto.class);
                startActivity(intent);
            }
        });
        btnotra1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent( Opciones.this, Reclamo.class);
                startActivity(intent);
            }
        });
        btnotra2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent( Opciones.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}