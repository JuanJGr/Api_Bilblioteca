package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity

@Table(name = "Libros")

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(nullable = false, length = 150)
    private String autor;

    @Column(name = "Año publicación", nullable = false)
    private int Aniopublicacion;

    //OPTIONAL - lIBROS SIEMPRE DEBEN TENER UNA CATEGORIA
    //FETCH EAFER - CUANDO SE CARGA UN LIBRO TAMBIEN SE CARGA LA CATEGORIA

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "Catagoria id", nullable = false)
    @JsonBackReference
    private Categoria Categoria;

    public Libro() {
    }

    public Libro(Long id, String titulo, String autor, int aniopublicacion, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        Aniopublicacion = aniopublicacion;
        this.Categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAniopublicacion() {
        return Aniopublicacion;
    }

    public void setAniopublicacion(int aniopublicacion) {
        Aniopublicacion = aniopublicacion;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.Categoria = categoria;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", Aniopublicacion=" + Aniopublicacion +
                ", categoria=" + Categoria +
                '}';
    }
}
