package com.example.Lab1.service;

import com.example.Lab1.model.ListBase;
import com.example.Lab1.model.NotificationList;
import com.example.Lab1.model.ToDoList;

import jakarta.annotation.PostConstruct;

import com.example.Lab1.model.Autor;
import com.example.Lab1.model.BuyList;
import com.example.Lab1.model.ListType;
import com.example.Lab1.model.Lista;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListService {
  private final Map<String, ListBase> listas = new HashMap<>();

  public Collection<ListBase> getAllListBases() {
    return listas.values();
  }

  public Optional<ListBase> getListBaseById(String id) {
    return Optional.ofNullable(listas.get(id.toLowerCase()));
  }

  public List<ListBase> getListBasesByType(ListType tipo) {
    return listas.values().stream()
      .filter(lista -> lista.getClass().getSimpleName().equalsIgnoreCase(tipo.name() + "List"))
      .collect(Collectors.toList());
    }

  public ListBase addBaseLista(String id, String nombre, ListType listType) {
    ListBase nuevaLista;
    switch (listType) {
        case TODO:
            nuevaLista = new ToDoList(id, nombre);
            listas.put(id, nuevaLista);
            break;
        case BUY:
            nuevaLista = new BuyList(id, nombre);
            listas.put(id, nuevaLista);
            break;
        case NOTIFICATION:
            nuevaLista = new NotificationList(id, nombre);
            listas.put(id, nuevaLista);
            break;
        default:
            throw new IllegalArgumentException("Tipo de lista no soportado");
    }
    return nuevaLista;
  }

  // Eliminar una lista por su ID
  public void removeLista(String id) {
      listas.remove(id);
  }

  // Limpiar todas las listas
  public void clearListas() {
      listas.clear();
  }

  public Optional<Lista> getListBaseByIdAndListId(String id, String idLista) {
    Optional<ListBase> listaBase = getListBaseById(id);
    if (listaBase.isEmpty()) {
      return Optional.empty();
    }
    return Optional.ofNullable(listaBase.get().getLista(idLista));
  }

  @PostConstruct
  private void init() {
    ToDoList tdl = (ToDoList) addBaseLista("pendientes", "Lista de pendientes", ListType.TODO);
    BuyList bl = (BuyList) addBaseLista("compras", "Lista de compras", ListType.BUY);

    // Poblar ToDoList
    tdl.addLista("recordatorios", "Recordatorios");
    Lista recordatorios = tdl.getLista("recordatorios");
    recordatorios.addEntrada("paquete", "Recoger paquete de correos");
    recordatorios.addEntrada("reunion", "Reunión trimestral del colegio");

    Autor autor = new Autor("Juan", "juan@gmail.com");
    recordatorios.setAutor(autor);

    tdl.addLista("trabajos", "Trabajos Pendientes");
    Lista trabajos = tdl.getLista("trabajos");
    trabajos.addEntrada("ninot", "Hacer manualidad 'ninot de falla'");
    trabajos.addEntrada("rest", "Desarrollar API REST para asignatura ISC");
    Autor autor2 = new Autor("Pedro", "pedro@gmail.com");
    trabajos.setAutor(autor2);

    // Poblar BuyList
    bl.addLista("comida", "Lista de la compra de comida");
    Lista comida = bl.getLista("comida");
    comida.addEntrada("leche", "1 caja de 6 bricks de leche");
    comida.addEntrada("huevos", "1 docena de huevos");
    comida.addEntrada("arroz", "2 Kgs de arroz");
    comida.setAutor(autor);
}
}
