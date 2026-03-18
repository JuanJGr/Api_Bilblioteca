package com.example.demo.Service;

import com.example.demo.Model.Estudiante;
import java.util.List;

public interface EstudianteService {

    List<Estudiante> listar();

    Estudiante buscarPorId(Long id);

    Estudiante guardar(Estudiante estudiante);

    Estudiante actualizar(Long id, Estudiante estudiante);

    void eliminar(Long id);
}