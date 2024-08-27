# Blogging-Platform-CRUD-REST-API
 Projecto de API REST sobre una plataforma de blogs, consiste en un CRUD donde tenemos los endpoints y funcionalidades basicas para un CRUD, tambien en este readme se describe el problema del proyecto, cuales son los requerimientos y el planeto en general de este.

## Tecnologias

- Java
- REST API
- Spring Boot
- Spring Data JPA
- MySQL DB
- Lombok
- Swagger

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

### Diagrama de DB
La tabla se genera en base a nuestra @Entity class llamada Blog con la ayuda de JPA/Hibernate

![blog_table](https://github.com/user-attachments/assets/33d51cfc-3b5b-4859-8128-fd1db1c16651)


## Referencia de API

#### Obtener todos los objetos

```http
  GET /api/v1/blogs
```
#### Filtrado opcional por Tag
```http
  GET /api/v1/blogs?tag=example
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `tag` | `String` | **Not Required**. Tag por el que se quiere buscar |

#### Obtener un objeto segun el id

```http
  GET /api/v1/blogs/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id del objeto a retornar |

#### Crear un objeto en la DB

```http
  POST /api/v1/blogs
```

```json
{
    "title": "Primer dia en Alemania",
    "content": "Descripcion del blog en Alemania",
    "author": "Alonso Salas",
    "tags": [
        "Europa",
        "Cerveza"
    ]
}
```

#### Actualiza un objeto en la DB

```http
  POST /api/v1/blogs/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id del objeto a actualizar |

#### Eliminar un objeto en la DB

```http
  DELETE /api/v1/blogs/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id del objeto a eliminar |
