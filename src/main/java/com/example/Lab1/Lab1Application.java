package com.example.Lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Lab1.model.ListBase;
import com.example.Lab1.model.ListType;
import com.example.Lab1.model.Lista;
import com.example.Lab1.model.ToDoList;
import com.example.Lab1.service.ListService;

@SpringBootApplication
public class Lab1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
	}

	@Bean
	public ListBase listBase() {
    ListService listService = new ListService();
    ToDoList tdl = (ToDoList) listService.addBaseLista("pendientes", "Lista de pendientes", ListType.TODO);

    tdl.addLista("recordatorios", "Recordatorios");
    Lista recordatorios = tdl.getLista("recordatorios");
    recordatorios.addEntrada("paquete", "Recojer paquete de correos");
    recordatorios.addEntrada("reunion", "Reunion trimestral del colegio");
		System.out.println("recordatorios: " + recordatorios);
    return (ListBase) tdl;
	}
}
