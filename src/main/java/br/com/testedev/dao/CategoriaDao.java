package br.com.testedev.dao;

import br.com.testedev.domain.Categoria;

import java.util.List;

public interface CategoriaDao {

    void salvar(Categoria categoria);
    List<Categoria> recuperar();
    Categoria recuperarPorID(long id);
    void atualizar(Categoria categoria);
    void excluir(long id);

}
