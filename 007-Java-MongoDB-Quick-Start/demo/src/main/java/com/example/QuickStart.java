package com.example;

import static com.mongodb.client.model.Filters.eq;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class QuickStart {
    public static void main( String[] args ) {

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb://localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> collection = database.getCollection("movies");

            collection.insertOne(new Document("plot", "A young man is accidentally sent 30 years into the past... Again")
                    .append("genres", Arrays.asList("Adventure", "Comedy", "Sci-Fi"))
                    .append("title", "Back to the Future II"));

            Document doc = collection.find(eq("title", "Back to the Future II")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }

            collection.deleteOne(eq("title", "Back to the Future II"));

            collection.updateOne(eq("title", "Back to the Future II"), new Document("$set",new Document("plot", "A young man is accidentally sent 30 years into the past... Again")
            .append("genres", Arrays.asList("Adventures", "Comedies", "Sci-Fis"))
            .append("title", "Back to the Future II Reloaded")));

        }
    }
}