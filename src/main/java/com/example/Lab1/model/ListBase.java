package com.example.Lab1.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class ListBase {
    private String id;
    private String nombre;
    private Map<String, Lista> listas;

    public ListBase(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listas = new HashMap<>();
    }

    public void addLista(String id, String nombre) {
        listas.put(id, new Lista(id, nombre));
    }

    public Lista getLista(String id) {
        return listas.get(id);
    }

    public Collection<Lista> getListas() {
        for (Lista lista : listas.values()) {
            System.out.println(lista.getNombre());
        }
        return listas.values();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void clearListas() {
        listas.clear();
    }

    public void printListas() {
        for (Lista lista : listas.values()) {
            System.out.println(lista.getNombre());
        }
    }
}
