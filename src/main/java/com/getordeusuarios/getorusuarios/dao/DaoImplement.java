package com.getordeusuarios.getorusuarios.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.getordeusuarios.getorusuarios.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

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

	@Override
	public boolean verificarEmailPassword(Usuario usuario) {
		String query = "FROM Usuario WHERE email = :email";
        
        @SuppressWarnings("unchecked")
		List<Usuario> lista =  entityManager.createQuery(query)
        		.setParameter("email", usuario.getEmail())
        		.getResultList();
        
        if (lista.isEmpty()) {
			return false;
		}
        
        String passwordHashd = lista.get(0).getPassword();
        
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(passwordHashd, usuario.getPassword());
		
	}

}
