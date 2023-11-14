package com.biblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.biblioteca.model.Bibliotecario;

public interface BibliotecarioRepository  extends JpaRepository<Bibliotecario, Long> {
    
}
