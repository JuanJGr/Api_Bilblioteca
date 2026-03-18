package com.example.demo.Service.impl;

import com.example.demo.Model.PerfilUsuario;
import com.example.demo.Repository.PerfilUsuarioRepository;
import com.example.demo.Service.PerfilUsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioServiceImpl implements PerfilUsuarioService {

    private final PerfilUsuarioRepository repository;

    public PerfilUsuarioServiceImpl(PerfilUsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PerfilUsuario> listar() {
        return repository.findAll();
    }

    @Override
    public PerfilUsuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public PerfilUsuario guardar(PerfilUsuario perfil) {
        return repository.save(perfil);
    }

    @Override
    public PerfilUsuario actualizar(Long id, PerfilUsuario perfil) {
        perfil.setId(id);
        return repository.save(perfil);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}