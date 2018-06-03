package br.com.testedev.domain;


import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
    @Table(name = "discos")
    public class Disco {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @NotBlank
        @Size(min = 2, max = 50)
        @Column(nullable = false, length = 50)
        private String titulo;

        @NotBlank
        @Size(min = 2, max = 50)
        @Column(nullable = false, length = 50)
        private String album;

        @Range(min = 0, max = 10)
        @Column(nullable = false)
        private int nota;

        @ManyToOne
        @JoinColumn(name = "id_categoria_fk")
        private Categoria categoria;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
