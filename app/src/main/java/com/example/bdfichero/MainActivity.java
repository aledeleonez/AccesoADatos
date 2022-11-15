package com.example.bdfichero;

import static com.example.bdfichero.R.id.text_entrada;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText texto;
    private TextView textoEntrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (EditText) findViewById(R.id.text_Texto);
        textoEntrada = (TextView) findViewById(R.id.texto_entrada);
        String[] files = fileList();

        if(isFile(files, "datos.txt")){
            try{
                InputStreamReader file = new InputStreamReader(openFileInput("datos.txt"));
                BufferedReader bufferedReader = new BufferedReader(file);
                String line = bufferedReader.readLine();
                String all = "";
                while(line != null){
                    all = all + line + "\n";
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
                file.close();
                texto.setText(all);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private boolean isFile(String[] files, String file){
        for (int i = 0; i < files.length; i++) {
            if(file.equals(files[i])){
                return true;
            }
        }
        return false;
    }

    public void saveText(View view){
        String fileName = textoEntrada.getText().toString();
        fileName=fileName.replace('/','-');
        try{
            OutputStreamWriter file = new OutputStreamWriter(openFileOutput(fileName, Activity.MODE_PRIVATE));
            file.write(texto.getText().toString());
            file.flush();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Los datos fueron grabados", Toast.LENGTH_SHORT).show();
        textoEntrada.setText("");
        texto.setText("");
    }
}