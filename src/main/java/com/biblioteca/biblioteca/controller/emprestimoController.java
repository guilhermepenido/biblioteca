package com.biblioteca.biblioteca.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.dto.RealizarEmprestimoRequestDTO;
import com.biblioteca.biblioteca.service.EmprestimoService;
import com.biblioteca.biblioteca.model.Emprestimo;




@RestController
@RequestMapping("/emprestimos")
public class emprestimoController {

    private final EmprestimoService emprestimoService;


    public emprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/realizar")
    public void realizarEmprestimo(@RequestBody RealizarEmprestimoRequestDTO request) {


        emprestimoService.realizarEmprestimo(
            request.getBibliotecarioId(),
            request.getClienteId(),
            request.getLivroIds()
        );
    }

    @GetMapping
    public ResponseEntity<List<Emprestimo>> getAllEmprestimos() {
        List<Emprestimo> emprestimos = emprestimoService.getAllEmprestimos();
        return new ResponseEntity<>(emprestimos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> getEmprestimoById(@PathVariable Long id) {
        Emprestimo emprestimo = emprestimoService.getEmprestimoById(id);
        if (emprestimo != null) {
            return new ResponseEntity<>(emprestimo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ids")
    public ResponseEntity<List<Emprestimo>> getEmprestimoByIds(@RequestParam Set<Long> emprestimoIds) {
        List<Emprestimo> emprestimos = emprestimoService.getEmprestimoByIds(emprestimoIds);
        return new ResponseEntity<>(emprestimos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> atualizaEmprestimo(
            @PathVariable Long id,
            @RequestBody Emprestimo emprestimo) {
        ResponseEntity<Emprestimo> responseEntity = emprestimoService.atualizaEmprestimo(id, emprestimo);
        return new ResponseEntity<>(responseEntity.getBody(), responseEntity.getStatusCode());
    }

    @GetMapping("/livro/{livroId}")
    public ResponseEntity<List<Emprestimo>> getEmprestimosByLivroId(@PathVariable Long livroId) {
        List<Emprestimo> emprestimos = emprestimoService.getEmprestimosByLivroId(livroId);
        return new ResponseEntity<>(emprestimos, HttpStatus.OK);
    }

    @GetMapping("/bibliotecario/{bibliotecarioId}")
    public ResponseEntity<List<Emprestimo>> getEmprestimosByBNibliotecarioId(@PathVariable Long bibliotecarioId) {
        List<Emprestimo> emprestimos = emprestimoService.getEmprestimosByBibliotecarioId(bibliotecarioId);
        return new ResponseEntity<>(emprestimos, HttpStatus.OK);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Emprestimo>> getEmprestimosByClienteId(@PathVariable Long clienteId) {
        List<Emprestimo> emprestimos = emprestimoService.getEmprestimosByClienteId(clienteId);
        return new ResponseEntity<>(emprestimos, HttpStatus.OK);
    }

    @DeleteMapping("/entregar/{emprestimoId}")
    public ResponseEntity<Void> entregarLivro(@PathVariable Long emprestimoId) {
        emprestimoService.entregarLivro(emprestimoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}