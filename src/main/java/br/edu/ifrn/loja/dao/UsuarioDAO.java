/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.loja.dao;

import br.edu.ifrn.loja.model.Usuario;
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
public class UsuarioDAO {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional(readOnly = true)
    public List<Usuario> listar(){
        TypedQuery<Usuario> query = 
                entityManager.createQuery("select u from Usuario u", Usuario.class);
        return query.getResultList();
    }
    
    public void salvar(Usuario usuario){
        if (usuario.getId() == null)
            entityManager.persist(usuario);
        else
            entityManager.merge(usuario);
    }
    
}
