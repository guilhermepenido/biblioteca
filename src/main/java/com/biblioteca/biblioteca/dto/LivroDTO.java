package com.biblioteca.biblioteca.dto;

public class LivroDTO {
    private Long id;
    private String titulo;
    // Outros atributos, getters e setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
