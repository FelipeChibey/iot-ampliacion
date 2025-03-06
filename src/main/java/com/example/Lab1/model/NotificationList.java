package com.example.Lab1.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NotificationList extends ListBase {
    public NotificationList(String id, String nombre) {
        super(id, nombre);
    }

    private final Map<String, Lista> listas = new HashMap<>();

    public Collection<Lista> getNotificaciones() {;
        return listas.values();
    }

    public Lista getLista(String id) {
        return listas.get(id);
    }

    public void addLista(String id, String nombre) {
        listas.put(id, new Lista(id, nombre));
    }

    public void removeLista(String id) {
        listas.remove(id);
    }

    public void remove() {
        listas.clear();
    }
}
