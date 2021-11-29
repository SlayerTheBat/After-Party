package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Reclamo extends AppCompatActivity {
    ImageButton btnOtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamo);
        btnOtra = findViewById(R.id.imageButton2);
        btnOtra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent( Reclamo.this, Opciones.class);
                startActivity(intent);
            }
        });
    }
    }
