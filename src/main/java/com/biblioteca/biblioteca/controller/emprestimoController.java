package com.biblioteca.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.dto.RealizarEmprestimoRequestDTO;
import com.biblioteca.biblioteca.service.EmprestimoService;

import java.util.Set;

@RestController
@RequestMapping("/emprestimos")
public class emprestimoController {

    private final EmprestimoService emprestimoService;

    @Autowired
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
}