package com.example.appmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText usuario, contrasena, nombre, email;
    Button registrarse;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuario=findViewById(R.id.entrada_usuario);
        contrasena=findViewById(R.id.entrada_contrasena);
        nombre=findViewById(R.id.entrada_nombre);
        email=findViewById(R.id.entrada_email);
        registrarse=findViewById(R.id.but_registrarse);
        DB = new DBHelper(this);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = usuario.getText().toString();
                String contr = contrasena.getText().toString();
                String nom = nombre.getText().toString();
                String eMail = email.getText().toString();

                if (TextUtils.isEmpty(usr) || TextUtils.isEmpty(contr) || TextUtils.isEmpty(nom) || TextUtils.isEmpty(eMail)){
                    Toast.makeText(Registro.this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean comprobarUsuario = DB.comprobarUsuario(usr);
                    if (comprobarUsuario == false){
                        Boolean insertar = DB.insertarDatos(usr, contr, nom, eMail);
                        if (insertar){
                            Toast.makeText(Registro.this, "Registro completado con exito", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Menu.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Registro.this, "Hubo un fallo en el registro", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Registro.this, "Este usuario ya existe", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}