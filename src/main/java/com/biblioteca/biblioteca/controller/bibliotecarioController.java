package com.biblioteca.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.model.Bibliotecario;
import com.biblioteca.biblioteca.service.BibliotecarioService;

@RestController
@RequestMapping("/bibliotecarios")
public class bibliotecarioController {
 private BibliotecarioService bibliotecarioService;
@Autowired
    public void BibliotecarioController(BibliotecarioService bibliotecarioService) {
        this.bibliotecarioService = bibliotecarioService;
    }

    @GetMapping
    public ResponseEntity<List<Bibliotecario>> getAllBibliotecarios() {
        List<Bibliotecario> bibliotecarios = bibliotecarioService.getAllBibliotecarios();
        return new ResponseEntity<>(bibliotecarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> getBibliotecarioById(@PathVariable Long id) {
        Bibliotecario bibliotecario = bibliotecarioService.getBibliotecarioById(id);
        if (bibliotecario != null) {
            return new ResponseEntity<>(bibliotecario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Bibliotecario> createBibliotecario(@RequestBody Bibliotecario bibliotecario) {
        Bibliotecario savedBibliotecario = bibliotecarioService.createBibliotecario(bibliotecario);
        return new ResponseEntity<>(savedBibliotecario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bibliotecario> updateBibliotecario(@PathVariable Long id, @RequestBody Bibliotecario bibliotecario) {
        Bibliotecario updatedBibliotecario = bibliotecarioService.updateBibliotecario(id, bibliotecario);
        if (updatedBibliotecario != null) {
            return new ResponseEntity<>(updatedBibliotecario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBibliotecario(@PathVariable Long id) {
        boolean deleted = bibliotecarioService.deleteBibliotecario(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}