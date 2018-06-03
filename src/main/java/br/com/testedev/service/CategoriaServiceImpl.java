package br.com.testedev.service;

import br.com.testedev.dao.CategoriaDao;
import br.com.testedev.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public void salvar(Categoria categoria) {
        categoriaDao.salvar(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> recuperar() {
        return categoriaDao.recuperar();
    }

    @Override
    @Transactional
    public Categoria recuperarPorId(long id) {
        return categoriaDao.recuperarPorID(id);
    }

    @Override
    public void atualizar(Categoria categoria) {
        categoriaDao.atualizar(categoria);
    }

    @Override
    public void excluir(long id) {
        categoriaDao.excluir(id);
    }
}
