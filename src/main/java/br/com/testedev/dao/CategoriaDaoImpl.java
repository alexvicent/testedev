package br.com.testedev.dao;

import br.com.testedev.domain.Categoria;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoriaDaoImpl implements CategoriaDao{

    @PersistenceContext
    private EntityManager em;
    @Override
    public void salvar(Categoria categoria) {
        em.persist(categoria);
    }

    @Override
    public List<Categoria> recuperar() {
        return em.createQuery("select c from Categoria c", Categoria.class).getResultList();
    }

    @Override
    public Categoria recuperarPorID(long id) {
        return em.find(Categoria.class, id);
    }

    @Override
    public void atualizar(Categoria categoria) {
        em.merge(categoria);
    }

    @Override
    public void excluir(long id) {
        em.remove(em.getReference(Categoria.class, id));
    }
}
