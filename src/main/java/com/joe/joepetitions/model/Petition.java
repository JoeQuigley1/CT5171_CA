package com.joe.joepetitions.model;

import java.util.ArrayList;
import java.util.List;

public class Petition {
    private int id;
    private String title;
    private String description;
    private String author;

    private List<Signature> signatures = new ArrayList<>();

    public Petition() {}

    public Petition(int id, String title, String description, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public int getId() { return id; }
    public void setId(int id) {  this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) {  this.description = description; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) {  this.author = author; }

    public List<Signature> getSignatures() {
        return signatures;
    }
    public void addSignature(Signature signature) {
        this.signatures.add(signature);
    }
}

