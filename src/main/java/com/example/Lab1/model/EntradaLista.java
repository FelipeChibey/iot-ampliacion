package com.example.Lab1.model;

public class EntradaLista {
    private final String id;
    private String text;

    public EntradaLista(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void updateText(String text) {
        this.text = text;
    }
}
