package br.com.testedev.dao;

import br.com.testedev.domain.Disco;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DiscoDaoImpl implements DiscoDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Disco disco) {
        em.persist(disco);
    }

    @Override
    public List<Disco> recuperarPorCategoria(long categoriaId) {
        return em.createQuery("select d from Disco d where d.categoria.id = :categoriaId", Disco.class)
                .setParameter("categoriaId", categoriaId)
                .getResultList();
    }

    @Override
    public Disco recuperarPorCategoriaIdEDiscoId(long categoriaId, long discoId) {
        return em.createQuery("select d from Disco d where d.categoria.id = :categoriaId and d.id = :discoId", Disco.class)
                .setParameter("categoriaId", categoriaId)
                .setParameter("discoId", discoId)
                .getSingleResult();
    }

    @Override
    public void atualizar(Disco disco) {

        em.merge(disco);

    }

    @Override
    public void excluir(long discoId) {
        em.remove(em.getReference(Disco.class, discoId));
    }
}
