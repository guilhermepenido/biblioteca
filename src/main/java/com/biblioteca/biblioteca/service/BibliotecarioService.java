package com.biblioteca.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.model.Bibliotecario;
import com.biblioteca.biblioteca.repository.BibliotecarioRepository;

@Service
public class BibliotecarioService {
    private final BibliotecarioRepository bibliotecarioRepository;

  
    public BibliotecarioService(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }

    public List<Bibliotecario> getAllBibliotecarios() {
        return bibliotecarioRepository.findAll();
    }

    public Bibliotecario getBibliotecarioById(Long id) {
        Optional<Bibliotecario> bibliotecario = bibliotecarioRepository.findById(id);
        return bibliotecario.orElse(null);
    }

    public Bibliotecario createBibliotecario(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }

    public Bibliotecario updateBibliotecario(Long id, Bibliotecario bibliotecario) {
        if (bibliotecarioRepository.existsById(id)) {
            bibliotecario.setId(id);
            return bibliotecarioRepository.save(bibliotecario);
        }
        return null; // Bibliotecario não encontrado
    }

    public boolean deleteBibliotecario(Long id) {
        if (bibliotecarioRepository.existsById(id)) {
            bibliotecarioRepository.deleteById(id);
            return true;
        }
        return false; // Bibliotecario não encontrado
    }
}
