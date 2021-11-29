package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Motivo extends AppCompatActivity {
    Button btnOtra1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivo);
        btnOtra1 = findViewById(R.id.buttonEn);
        btnOtra1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent( Motivo.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}