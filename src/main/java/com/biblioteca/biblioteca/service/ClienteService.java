package com.biblioteca.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.model.Cliente;
import com.biblioteca.biblioteca.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;


    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    public Cliente createCliente(Cliente usuario) {
        return clienteRepository.save(usuario);
    }

    public Cliente updateCliente(Long id, Cliente usuario) {
        if (clienteRepository.existsById(id)) {
            usuario.setId(id);
            return clienteRepository.save(usuario);
        }
        return null; // Usuario não encontrado
    }

    public boolean deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false; // Usuario não encontrado
    }
}
