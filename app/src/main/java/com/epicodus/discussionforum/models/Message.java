package com.epicodus.discussionforum.models;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class Message {
    private String mMessage;
    private String mAuthor;
    private String mCategory;

    public Message (String message, String author, String category) {
        this.mMessage = message;
        this.mAuthor = author;
        this.mCategory = category;
    }

    public String getMessage() {

        return mMessage;
    }
    public String getAuthor() {

        return mAuthor;
    }
    public String getCategory() {

        return mCategory;
    }
}
