package com.example.Lab1.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BuyList extends ListBase {
    public BuyList(String id, String nombre) {
        super(id, nombre);
    }

    private final Map<String, Lista> listas = new HashMap<>();

    public Collection<Lista> getProductos() {
        return listas.values();
    }

    public void removeLista(String id) {
        listas.remove(id);
    }

    public void remove() {
        listas.clear();
    }
}
