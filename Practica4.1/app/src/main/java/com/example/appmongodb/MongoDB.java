package com.example.appmongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;


import org.bson.Document;

import java.text.ParseException;

public class MongoDB {

    private MongoClient mongoClient;
    private MongoDatabase db;

    public void conectar(){
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase("usuarios");
    }

    public void desconectar(){
        mongoClient.close();
    }

    public boolean anadirUsuario(Usuario usuario){
        Document documento = new Document()
                .append("nombre", usuario.getNombre())
                .append("contrasena", usuario.getContrasena())
                .append("email", usuario.geteMail())
                .append("usuario", usuario.getUsuario());
        InsertOneResult result = db.getCollection("usuarios").insertOne(documento);
        if(result.wasAcknowledged()){
            return true;
        }else{
            return false;
        }
    }

    public void eliminarUsuario(String usuario){
        db.getCollection("usuarios").deleteOne(new Document("nombre", usuario));
    }

    public boolean comprobarUsuario(String usuario){
        FindIterable<Document> findIterable = db.getCollection("usuarios").find(new Document("usuario", usuario));
        if (findIterable.first().isEmpty()){
            return false;
        }else{
            return true;
        }

    }


}
