package br.com.testedev.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


    @Entity
    @Table(name = "categorias")
    public class Categoria {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @NotBlank
        @Size(min = 2, max = 60)
        @Column(nullable = false, length = 60)
        private String nome;

        @NotBlank
        @Column(nullable = false)
        private String descricao;

        @OneToMany(mappedBy ="categoria", cascade = CascadeType.ALL)
        private List<Disco> discos;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public List<Disco> getDiscos() {
            return discos;
        }

        public void setDiscos(List<Disco> discos) {
            this.discos = discos;
        }

}
