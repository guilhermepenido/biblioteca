package com.biblioteca.biblioteca.service;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.biblioteca.biblioteca.model.Bibliotecario;
import com.biblioteca.biblioteca.model.Cliente;
import com.biblioteca.biblioteca.model.Emprestimo;
import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.EmprestimoRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final BibliotecarioService bibliotecarioService;
    private final ClienteService clienteService;
    private final LivroService livroService;

    
    public EmprestimoService(EmprestimoRepository emprestimoRepository,
            BibliotecarioService bibliotecarioService,
            ClienteService clienteService,
            LivroService livroService) {
        this.emprestimoRepository = emprestimoRepository;
        this.bibliotecarioService = bibliotecarioService;
        this.clienteService = clienteService;
        this.livroService = livroService;
    }

    public void realizarEmprestimo(Long bibliotecarioId, Long clienteId, Set<Long> livroIds) {
        // Recuperar o bibliotecário, cliente e livros
        Bibliotecario bibliotecario = bibliotecarioService.getBibliotecarioById(bibliotecarioId);
        Cliente cliente = clienteService.getClienteById(clienteId);
        Set<Livro> livros = new HashSet<>(livroService.getLivrosByIds(livroIds));

        // Criar um novo empréstimo
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setBibliotecario(bibliotecario);
        emprestimo.setCliente(cliente);
        emprestimo.setLivros(livros);

        // Salvar o empréstimo no banco de dados
        emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> getAllEmprestimos() {
        return emprestimoRepository.findAll();
    }

     public Emprestimo getEmprestimoById(Long id) {
        Optional<Emprestimo> emprestimo = emprestimoRepository.findById(id);
        return emprestimo.orElse(null);
    }

    public List<Emprestimo> getEmprestimoByIds(Set<Long> emprestimoIds) {
        return emprestimoRepository.findAllById(emprestimoIds);
    }

    
    public ResponseEntity<Emprestimo> atualizaEmprestimo(Long id, Emprestimo item) {
        Optional<Emprestimo> existingItemOptional = emprestimoRepository.findById(id);
        if (existingItemOptional.isPresent()) {
            Emprestimo existingItem = existingItemOptional.get();
            emprestimoRepository.save(existingItem);
            return new ResponseEntity<>(existingItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public List<Emprestimo> getEmprestimosByLivroId(Long livroId) {
        return emprestimoRepository.findByLivrosId(livroId);
    }

    public List<Emprestimo> getEmprestimosByClienteId(Long clienteId) {
        return emprestimoRepository.findByClienteId(clienteId);
    }

    public List<Emprestimo> getEmprestimosByBibliotecarioId(Long bibliotecarioId) {
        return emprestimoRepository.findByBibliotecarioId(bibliotecarioId);
    }

    public ResponseEntity<String> entregarLivro(Long emprestimoId) {
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(emprestimoId);
        if (emprestimoOptional.isPresent()) {
            Emprestimo emprestimo = emprestimoOptional.get();
            emprestimoRepository.delete(emprestimo);
            emprestimoRepository.save(emprestimo); 
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Empréstimo não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    
}