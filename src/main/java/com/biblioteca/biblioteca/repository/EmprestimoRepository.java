package com.biblioteca.biblioteca.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.biblioteca.model.Emprestimo;
import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findByLivrosId(Long livroId);
    List<Emprestimo> findByClienteId(Long clienteId);
    List<Emprestimo> findByBibliotecarioId(Long bibliotecarioId);
}