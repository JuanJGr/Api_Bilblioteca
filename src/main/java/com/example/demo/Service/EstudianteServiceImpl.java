package com.example.demo.Service.impl;

import com.example.demo.Model.Estudiante;
import com.example.demo.Repository.EstudianteRepository;
import com.example.demo.Service.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteServiceImpl(EstudianteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estudiante> listar() {
        return repository.findAll();
    }

    @Override
    public Estudiante buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    @Override
    public Estudiante actualizar(Long id, Estudiante estudiante) {
        estudiante.setId(id);
        return repository.save(estudiante);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}