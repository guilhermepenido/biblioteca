package com.biblioteca.biblioteca.controller;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.service.LivroService;

@RestController
@RequestMapping("/livros")
public class livroController {
    private LivroService livroService;
@Autowired
    public void LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroService.getAllLivros();
    }

    @GetMapping("/ids/{livroIds}")
    public List<Livro> getLivrosByIds(@PathVariable Set<Long> livroIds) {
        return livroService.getLivrosByIds(livroIds);
    }

    @GetMapping("/{livroId}")
    public Livro getLivroById(@PathVariable Long livroId) {
        return livroService.getLivroById(livroId);
    }

    @PostMapping
    public Livro createLivro(@RequestBody Livro livro) {
        return livroService.createLivro(livro);
    }

    @PutMapping("/{id}")
    public Livro updateLivro(@PathVariable Long id, @RequestBody Livro livro) {
        return livroService.updateLivro(id, livro);
    }

    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable Long id) {
        livroService.deleteLivro(id);
    }
}
