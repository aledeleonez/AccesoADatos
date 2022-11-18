package com.example.appmysql;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    EditText usuario, contrasena, nombre, email;
    Button registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuario=findViewById(R.id.entrada_usuario);
        contrasena=findViewById(R.id.entrada_contrasena);
        nombre=findViewById(R.id.entrada_nombre);
        email=findViewById(R.id.entrada_email);
        registrarse=findViewById(R.id.but_registrarse);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}