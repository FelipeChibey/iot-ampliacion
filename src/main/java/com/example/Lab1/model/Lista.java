package com.example.Lab1.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Lista {
    private final String id;
    private String nombre;
    private final Map<String, EntradaLista> entradas = new HashMap<>();
    private Autor autor;

    public Lista(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<EntradaLista> getEntradas() {
        return entradas.values();
    }

    public EntradaLista getEntrada(String id) {
        return entradas.get(id);
    }

    public EntradaLista addEntrada(String id, String text) {
        EntradaLista entrada = new EntradaLista(id, text);
        entradas.put(id, entrada);
        return entrada;
    }

    public void removeEntrada(String id) {
        entradas.remove(id);
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }
}
