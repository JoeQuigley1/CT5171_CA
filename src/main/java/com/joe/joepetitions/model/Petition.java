package com.joe.joepetitions.model;

public class Petition {
    private int id;
    private String title;
    private String description;
    private String author;

    public Petition(int id, String title, String description, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getAuthor() { return author; }
}

