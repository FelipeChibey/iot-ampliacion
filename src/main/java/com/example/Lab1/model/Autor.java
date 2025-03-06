package com.example.Lab1.model;

public class Autor {
    private String nombre;
    private String email;

    public Autor(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
