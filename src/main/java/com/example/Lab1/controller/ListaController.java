package com.example.Lab1.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Lab1.model.Lista;
import com.example.Lab1.service.ListService;

@RestController
@RequestMapping("/listas/{id}/list/{idLista}")
public class ListaController {
  private final ListService listService;
  public ListaController(ListService listService) {
    this.listService = listService;
  }

  @GetMapping
  public ResponseEntity<?> getListBaseByIdAndListId(@PathVariable String id, @PathVariable String idLista) {
    Optional<Lista> lista = listService.getListBaseByIdAndListId(id, idLista);
    if (!lista.isPresent()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(lista.get());
  }

  @GetMapping("/autor")
  public ResponseEntity<?> getListAutor(@PathVariable String id, @PathVariable String idLista) {
    Optional<Lista> lista = listService.getListBaseByIdAndListId(id, idLista);
    if (!lista.isPresent()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(lista.get().getAutor());
  }

  @PutMapping
  public ResponseEntity<?> updateLista(@PathVariable String id, @PathVariable String idLista, @RequestBody Map<String, String> payload) {
    Optional<Lista> lista = listService.getListBaseByIdAndListId(id, idLista);
    if (lista == null) {
      return ResponseEntity.notFound().build();
    }
    lista.get().setNombre(payload.get("nombre"));
    return ResponseEntity.ok(lista);
  }
}
