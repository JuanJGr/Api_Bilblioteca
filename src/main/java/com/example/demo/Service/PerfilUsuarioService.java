package com.example.demo.Service;

import com.example.demo.Model.PerfilUsuario;
import java.util.List;

public interface PerfilUsuarioService {

    List<PerfilUsuario> listar();

    PerfilUsuario buscarPorId(Long id);

    PerfilUsuario guardar(PerfilUsuario perfil);

    PerfilUsuario actualizar(Long id, PerfilUsuario perfil);

    void eliminar(Long id);
}