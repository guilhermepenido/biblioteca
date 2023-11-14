package com.biblioteca.biblioteca.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.LivroRepository;

@Service
public class LivroService {
    private final LivroRepository livroRepository;


    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    public List<Livro> getLivrosByIds(Set<Long> livroIds) {
        return livroRepository.findAllById(livroIds);
    }

    public Livro getLivroById(Long livroId) {
        Optional<Livro> livroOptional = livroRepository.findById(livroId);
        return livroOptional.orElse(null);
    }

    public Livro createLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro updateLivro(Long id, Livro livro) {
        if (livroRepository.existsById(id)) {
            livro.setId(id);
            return livroRepository.save(livro);
        }
        return null; // Livro não encontrado
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
