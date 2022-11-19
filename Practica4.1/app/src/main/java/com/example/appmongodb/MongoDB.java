package com.example.appmongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;


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

    public void anadirUsuario(Usuario usuario){
        Document documento = new Document()
                .append("nombre", usuario.getNombre())
                .append("contrasena", usuario.getContrasena())
                .append("email", usuario.geteMail())
                .append("usuario", usuario.getUsuario());
        db.getCollection("usuarios").insertOne(documento);
    }

    public void eliminarUsuario(String usuario){
        db.getCollection("usuarios").deleteOne(new Document("nombre", usuario));
    }

    public Usuario buscarUsuario(String usuario) throws ParseException {
        FindIterable<Document> findIterable = db.getCollection("usuarios").find(new Document("usuario", usuario));
        Document documento = findIterable.first();
        return buscarUsuario(String.valueOf(documento));
    }


}
