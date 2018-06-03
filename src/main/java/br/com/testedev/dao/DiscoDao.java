package br.com.testedev.dao;



import br.com.testedev.domain.Disco;

import java.util.List;

public interface DiscoDao {

    void salvar(Disco disco);
    List<Disco> recuperarPorCategoria(long categoriaId);
    Disco recuperarPorCategoriaIdEDiscoId(long categoriaId, long discoId);
    void atualizar(Disco disco);
    void excluir(long discoId);

}
