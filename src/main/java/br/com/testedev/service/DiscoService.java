package br.com.testedev.service;

import br.com.testedev.domain.Disco;


import java.util.List;

public interface DiscoService {

    void salvar(Disco disco, long categoriaId);
    List<Disco> recuperarPorCategoria(long categoriaId);
    Disco recuperarPorCategoriaIdEDiscoId(long categoriaId, long discoId);
    void atualizar(Disco disco, long categoriaId);
    void excluir(long categoriaId, long Id);

}
