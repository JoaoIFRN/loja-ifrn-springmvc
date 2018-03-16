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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joaon
 */
@Repository
@Transactional
public class ProdutoDAO {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional(readOnly = true)
    public List<Produto> listar(){
        TypedQuery<Produto> query = entityManager.createQuery("from Produto", Produto.class);
        return query.getResultList();
    }
    
    public Produto buscarProduto(Integer id){
        return entityManager.find(Produto.class, id);
    }
    
    public void salvar(Produto produto){
        if (produto.getId() == null)
            entityManager.persist(produto);
        else
            entityManager.merge(produto);
    }
    
    public void excluir(Integer id){
        Produto produto = entityManager.find(Produto.class, id);
        entityManager.remove(produto);
    }
}
