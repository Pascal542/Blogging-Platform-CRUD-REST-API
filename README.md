﻿# Blogging-Platform-CRUD-REST-API
 Projecto de API REST sobre una plataforma de blogs, consiste en un CRUD donde tenemos los endpoints y funcionalidades basicas para un CRUD, tambien en este readme se describe el problema del proyecto, cuales son los requerimientos y el planeto en general de este.

## Tecnologias

- Java
- Spring Boot
- REST API
- Spring Data JPA
- MySQL DB

## Dependencias de Spring

- Spring Web
- Spring Data JPA
- Spring Dev Tools
- Spring MySQL Driver
- Lombok

## El problema

Se requiere crear una API RESTful con operaciones CRUD básicas para una plataforma de blogs personales.

### Requisitos

- Crear una publicacion de blog
- Actualizar una publicacion de blog existente
- Eliminar una publicación de blog existente
- Obtenga una sola publicación de blog
- Obtener todas las publicaciones del blog
- Filtrar publicaciones de blog por un término de búsqueda

## La solucion

Lo primero que hay que pensar es en como se almacenarian los datos en mi MySQL DB

### Diagrama de DB
La tabla se genera en base a nuestra @Entity class llamada Blog con la ayuda de JPA/Hibernate
![blog_table](https://github.com/user-attachments/assets/33d51cfc-3b5b-4859-8128-fd1db1c16651)
