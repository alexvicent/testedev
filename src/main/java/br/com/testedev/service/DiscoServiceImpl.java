package br.com.testedev.service;

import br.com.testedev.dao.DiscoDao;
import br.com.testedev.domain.Disco;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class DiscoServiceImpl implements DiscoService {

    @Autowired
    private DiscoDao discoDao;

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public void salvar(Disco disco, long categoriaId) {
        disco.setCategoria(categoriaService.recuperarPorId(categoriaId));
        discoDao.salvar(disco);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Disco> recuperarPorCategoria(long categoriaId) {
        return discoDao.recuperarPorCategoria(categoriaId);
    }

    @Override
    @Transactional(readOnly = true)
    public Disco recuperarPorCategoriaIdEDiscoId(long categoriaId, long discoId) {
        return discoDao.recuperarPorCategoriaIdEDiscoId(categoriaId, discoId);
    }

    @Override
    public void atualizar(Disco disco, long categoriaId) {
        disco.setCategoria(categoriaService.recuperarPorId(categoriaId));
        discoDao.atualizar(disco);
    }

    @Override
    public void excluir(long categoriaId, long discoId) {
        discoDao.excluir(recuperarPorCategoriaIdEDiscoId(categoriaId, discoId).getId());
    }
}
