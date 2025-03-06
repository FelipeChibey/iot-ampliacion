package com.example.Lab1.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Lab1.model.EntradaLista;
import com.example.Lab1.model.Lista;
import com.example.Lab1.service.ListService;



@RestController
@RequestMapping("listas/{id}/list/{idLista}/entradas")
public class EntradaListaController {
  private final ListService listService;
  public EntradaListaController(ListService listService) {
    this.listService = listService;
  }

  @GetMapping
  public ResponseEntity<?> getEntradas(@PathVariable String id, @PathVariable String idLista) {
    Optional<Lista> lista = listService.getListBaseByIdAndListId(id, idLista);
    if (!lista.isPresent()) {
      return ResponseEntity.notFound().build();
    }
    Collection<EntradaLista> entradas = lista.get().getEntradas();
    return ResponseEntity.ok(entradas);
  }
}
