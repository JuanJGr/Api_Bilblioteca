package com.example.demo.Service;

import com.example.demo.Model.Curso;
import java.util.List;

public interface CursoService {

    List<Curso> listar();

    Curso buscarPorId(Long id);

    Curso guardar(Curso curso);

    Curso actualizar(Long id, Curso curso);

    void eliminar(Long id);
}