package com.example.demo.Service;

import com.example.demo.Model.Libro;
import java.util.List;

public interface LibroService {

    List<Libro> listar();

    Libro buscarPorId(Long id);

    Libro guardar(Libro libro);

    Libro actualizar(Long id, Libro libro);

    void eliminar(Long id);
}