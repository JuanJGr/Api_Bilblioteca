package com.example.demo.Service.impl;

import com.example.demo.Model.Curso;
import com.example.demo.Repository.CursoRepository;
import com.example.demo.Service.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repository;

    public CursoServiceImpl(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Curso> listar() {
        return repository.findAll();
    }

    @Override
    public Curso buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Curso guardar(Curso curso) {
        return repository.save(curso);
    }

    @Override
    public Curso actualizar(Long id, Curso curso) {
        curso.setId(id);
        return repository.save(curso);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}