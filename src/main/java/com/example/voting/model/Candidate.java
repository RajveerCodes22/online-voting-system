package com.example.voting.model;

public class Candidate {
    public int id;
    public String name;
    public int votes = 0;

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }
}