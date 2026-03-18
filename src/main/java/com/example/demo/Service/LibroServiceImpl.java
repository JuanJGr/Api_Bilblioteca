package com.example.demo.Service.impl;

import com.example.demo.Model.Libro;
import com.example.demo.Repository.LibroRepository;
import com.example.demo.Service.LibroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository repository;

    public LibroServiceImpl(LibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Libro> listar() {
        return repository.findAll();
    }

    @Override
    public Libro buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Libro guardar(Libro libro) {
        return repository.save(libro);
    }

    @Override
    public Libro actualizar(Long id, Libro libro) {
        libro.setId(id);
        return repository.save(libro);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}