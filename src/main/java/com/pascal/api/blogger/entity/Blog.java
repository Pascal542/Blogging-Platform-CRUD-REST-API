package com.pascal.api.blogger.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "blog_posts")
public class Blog {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "El titulo no puede ser nulo")
    @NotBlank(message = "El titulo no puede ser vacio")
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull(message = "El contenido no puede ser nulo")
    @NotBlank(message = "El contenido no puede ser vacio")
    @Column(name = "content", nullable = false)
    private String content;

    @NotNull(message = "El autor no puede ser nulo")
    @NotBlank(message = "El autor no puede ser vacio")
    @Column(name = "author", unique = true, nullable = false)
    private String author;

    @Column(name = "tags")
    private List<String> tags;
}