package com.example.Lab1.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Lab1.model.ListBase;
import com.example.Lab1.model.ListType;
import com.example.Lab1.service.ListService;

@RestController
@RequestMapping("/listas")
public class ListBaseController {
  private final ListService listService;

  public ListBaseController(ListService listService) {
    this.listService = listService;
  }

  @GetMapping
  public Collection<ListBase> getAllListBases() {
    return listService.getAllListBases();
  }

  @GetMapping("/type/{tipo}")
  public List<ListBase> getListBasesByType(@PathVariable String tipo) {
  try {
    ListType listType = ListType.valueOf(tipo.toUpperCase());
      return listService.getListBasesByType(listType);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Tipo no válido. Usa TODO, BUY o NOTIFICATION.");
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<ListBase> getListBaseById(@PathVariable String id) {
    Optional<ListBase> listaBase = listService.getListBaseById(id);
    return listaBase.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping
  public ResponseEntity<?> deleteTodoList() {
    // list.remove();
    return ResponseEntity.ok().build();
  }
}
