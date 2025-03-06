# 📌 iot-ampliacion
**Ampliación de la API REST para gestión de listas**

## 📖 Descripción
Esta ampliación de la API REST introduce una nueva clase padre llamada `ListBase`, la cual es una clase abstracta de la que heredan las clases `ToDoList` y `BuyList`.

La API se ha modificado para que una `BaseList` pueda ser de tipo `ToDoList` o `BuyList`. Para acceder a los datos de estas listas a través de la API, se han creado diferentes controladores.

Las `BaseList` pueden contener varias `Listas` y a su ve estas pueden contener varias `EntredaLista`.

Entonces las rutas de la API quedan definidas de la siguiente forma

---

## 📌 Rutas de la API

| **Ruta** | **Descripción** | **Controlador** |
|----------|---------------|----------------|
| `/listas` | Devuelve la lista completa de todas las listas (`ToDoList` y `BuyList`). | `ListBaseController` |
| `/listas/type/{tipo}` | Devuelve las listas filtradas por tipo (`BuyList` o `ToDoList`). | `ListBaseController` |
| `/listas/id/{id}` | Devuelve una lista (`ToDoList` o `BuyList`) buscada por su ID. | `ListBaseController` |
| `/listas/{id}/list/{idLista}` | Devuelve la información detallada de una lista (`ToDoList` o `BuyList`). | `ListaController` |
| `/listas/{id}/list/{idLista}/autor` | Devuelve la información del autor de la lista. | `ListaController` |
| `/listas/{id}/list/{idLista}/entradas` | Devuelve la información de las entradas que pertenecen a la lista seleccionada. | `EntradaListaController` |

---
