package com.getordeusuarios.getorusuarios.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.getordeusuarios.getorusuarios.models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class DaoImplement implements UsuarioDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        
        return entityManager.createQuery(query).getResultList();
        
    }

}
