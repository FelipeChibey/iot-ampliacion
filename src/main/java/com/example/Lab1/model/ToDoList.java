package com.example.Lab1.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ToDoList extends ListBase {
    public ToDoList(String id, String nombre) {
        super(id, nombre);
    }

    private final Map<String, Lista> listas = new HashMap<>();

    public Collection<Lista> getTareas() {
        return listas.values();
    }

    public void removeLista(String id) {
        listas.remove(id);
    }

    public void remove() {
        listas.clear();
    }
}

