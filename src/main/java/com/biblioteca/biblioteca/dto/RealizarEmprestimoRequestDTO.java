package com.biblioteca.biblioteca.dto;

import java.util.Set;

public class RealizarEmprestimoRequestDTO  {

    private Long bibliotecarioId;
    private Long clienteId;
    private Set<Long> livroIds;
    public Long getBibliotecarioId() {
        return bibliotecarioId;
    }
    public void setBibliotecarioId(Long bibliotecarioId) {
        this.bibliotecarioId = bibliotecarioId;
    }
    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    public Set<Long> getLivroIds() {
        return livroIds;
    }
    public void setLivroIds(Set<Long> livroIds) {
        this.livroIds = livroIds;
    }

    // Getters e Setters
}