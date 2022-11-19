package com.example.appmongodb;


import com.mongodb.ClientSessionOptions;
import com.mongodb.client.ChangeStreamIterable;
import com.mongodb.client.ClientSession;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.connection.ClusterDescription;

import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

public class MongoDB {

   MongoClient mongoClient = new MongoClient() {
       @Override
       public MongoDatabase getDatabase(String databaseName) {
           return null;
       }

       @Override
       public ClientSession startSession() {
           return null;
       }

       @Override
       public ClientSession startSession(ClientSessionOptions options) {
           return null;
       }

       @Override
       public void close() {

       }

       @Override
       public MongoIterable<String> listDatabaseNames() {
           return null;
       }

       @Override
       public MongoIterable<String> listDatabaseNames(ClientSession clientSession) {
           return null;
       }

       @Override
       public ListDatabasesIterable<Document> listDatabases() {
           return null;
       }

       @Override
       public ListDatabasesIterable<Document> listDatabases(ClientSession clientSession) {
           return null;
       }

       @Override
       public <TResult> ListDatabasesIterable<TResult> listDatabases(Class<TResult> tResultClass) {
           return null;
       }

       @Override
       public <TResult> ListDatabasesIterable<TResult> listDatabases(ClientSession clientSession, Class<TResult> tResultClass) {
           return null;
       }

       @Override
       public ChangeStreamIterable<Document> watch() {
           return null;
       }

       @Override
       public <TResult> ChangeStreamIterable<TResult> watch(Class<TResult> tResultClass) {
           return null;
       }

       @Override
       public ChangeStreamIterable<Document> watch(List<? extends Bson> pipeline) {
           return null;
       }

       @Override
       public <TResult> ChangeStreamIterable<TResult> watch(List<? extends Bson> pipeline, Class<TResult> tResultClass) {
           return null;
       }

       @Override
       public ChangeStreamIterable<Document> watch(ClientSession clientSession) {
           return null;
       }

       @Override
       public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, Class<TResult> tResultClass) {
           return null;
       }

       @Override
       public ChangeStreamIterable<Document> watch(ClientSession clientSession, List<? extends Bson> pipeline) {
           return null;
       }

       @Override
       public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, List<? extends Bson> pipeline, Class<TResult> tResultClass) {
           return null;
       }

       @Override
       public ClusterDescription getClusterDescription() {
           return null;
       }
   };
   MongoDatabase db = mongoClient.getDatabase("usuarios");

}
