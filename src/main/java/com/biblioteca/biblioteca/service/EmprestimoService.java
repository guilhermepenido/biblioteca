package com.biblioteca.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.model.Bibliotecario;
import com.biblioteca.biblioteca.model.Cliente;
import com.biblioteca.biblioteca.model.Emprestimo;
import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.EmprestimoRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final BibliotecarioService bibliotecarioService;
    private final ClienteService clienteService;
    private final LivroService livroService;

    @Autowired
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
}