package com.example.appmysql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNOMBRE="login.db";
    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table usuarios(usuario TEXT primary key, contrasena TEXT, email TEXT, nombre TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists usuarios");
    }

    public boolean insertarDatos(String usuario, String contrasena, String nombre, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("usuario", usuario);
        valores.put("contrasena", contrasena);
        valores.put("nombre", nombre);
        valores.put("eMail", email);

        long resultado = db.insert("usuarios", null, valores);
        if (resultado == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean comprobarUsuario(String usuario){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from usuarios where usuario=?", new String[] {usuario});
        if (cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean comprobarContrasena(String usuario, String contrasena){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from usuarios where usuario=? and contrasena=?", new String[] {usuario, contrasena});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
}
