package com.getordeusuarios.getorusuarios.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.getordeusuarios.getorusuarios.models.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class DaoImplement implements UsuarioDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        
        return entityManager.createQuery(query).getResultList();
        
    }

	@Override
	public void eliminar(Long id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.remove(usuario);
		
	}

	@Override
	public void registrar(Usuario usuario) {
		entityManager.merge(usuario);
		
	}

}
