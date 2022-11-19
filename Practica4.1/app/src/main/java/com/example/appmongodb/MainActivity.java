package com.example.appmongodb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText usuario, contrasena;
    Button iniciarSesion, registrarse;
    MongoDB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.entradaUsuario);
        contrasena = findViewById(R.id.entradaContraseña);
        iniciarSesion = findViewById(R.id.butIniciarSesion);
        registrarse = findViewById(R.id.butRegistrarse);
        DB = new DBHelper(this);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
            }
        });

        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = usuario.getText().toString();
                String contr = contrasena.getText().toString();

                if (TextUtils.isEmpty(usr) || TextUtils.isEmpty(contr)){
                    Toast.makeText(MainActivity.this, "Faltan datos", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean comprobarContrasena = DB.comprobarContrasena(usr, contr);
                    if (comprobarContrasena){
                        Toast.makeText(MainActivity.this, "Has iniciado sesion correctamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Menu.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Error de usuario o contraseña", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
}