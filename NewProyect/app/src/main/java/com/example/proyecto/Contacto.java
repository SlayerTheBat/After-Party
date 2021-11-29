package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Contacto extends AppCompatActivity {
    Button btnOtra;
    private EditText CorreoD;
    private EditText Telefono;
    private EditText Comentario;
    ContactoSQLite sqLite=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        CorreoD =findViewById(R.id.TextCorreoD);
        Telefono =findViewById(R.id.TextTelefono);
        Comentario =findViewById(R.id.TextComentario);
        btnOtra = findViewById(R.id.buttoncon);
        sqLite= new ContactoSQLite(this);
        btnOtra.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                ContactoDatos cd= new ContactoDatos();
                cd.setCorreo(CorreoD.getText().toString());
                cd.setTelefono(Telefono.getText().toString());
                cd.setComentario(Comentario.getText().toString());
                sqLite.crearComentario(cd);
                Intent intent = new Intent( Contacto.this, Opciones.class);
                startActivity(intent);
            }
        });
    }
}