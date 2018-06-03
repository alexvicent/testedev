package br.com.testedev.service;

import br.com.testedev.domain.Categoria;

import java.util.List;

public interface CategoriaService {

    void salvar(Categoria categoria);
    List<Categoria> recuperar();
    Categoria recuperarPorId(long id);
    void atualizar(Categoria categoria);
    void excluir(long id);

}
