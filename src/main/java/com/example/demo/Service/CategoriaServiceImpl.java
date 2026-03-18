package com.example.demo.Service.impl;

import com.example.demo.Model.Categoria;
import com.example.demo.Repository.CategoriaRepository;
import com.example.demo.Service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> listar() {
        return repository.findAll();
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria actualizar(Long id, Categoria categoria) {
        categoria.setId(id);
        return repository.save(categoria);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}