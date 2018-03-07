/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.loja.dao;

import br.edu.ifrn.loja.model.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joaon
 */
@Repository
public class ProdutoDAO {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Produto> listar(){
        TypedQuery<Produto> query = entityManager.createQuery("from Produto", Produto.class);
        return query.getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
