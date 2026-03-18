package com.example.demo.Controller;

import com.example.demo.Model.PerfilUsuario;
import com.example.demo.Service.PerfilUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfiles")
public class PerfilUsuarioController {

    private final PerfilUsuarioService service;

    public PerfilUsuarioController(PerfilUsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PerfilUsuario>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilUsuario> buscar(@PathVariable Long id) {
        PerfilUsuario perfil = service.buscarPorId(id);

        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(perfil);
    }

    @PostMapping
    public ResponseEntity<PerfilUsuario> guardar(@RequestBody PerfilUsuario perfil) {
        PerfilUsuario nuevo = service.guardar(perfil);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilUsuario> actualizar(@PathVariable Long id, @RequestBody PerfilUsuario perfil) {

        if (service.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }

        PerfilUsuario actualizado = service.actualizar(id, perfil);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (service.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }

        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}