package com.epicodus.discussionforum.models;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class Message {
   String message;
    String author;
    String category;

    public Message() {}

    public Message(String message, String author, String category) {
        this.message = message;
        this.author = author;
        this.category = category;
    }

    public String getMessage() {

        return message;
    }
    public String getAuthor() {

        return author;
    }
    public String getCategory() {

        return category;
    }
}
