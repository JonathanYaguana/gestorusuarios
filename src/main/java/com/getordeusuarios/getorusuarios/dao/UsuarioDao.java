package com.getordeusuarios.getorusuarios.dao;

import java.util.List;
import com.getordeusuarios.getorusuarios.models.Usuario;

public interface UsuarioDao {
	List<Usuario> getUsuarios();

	void eliminar(Long id);
	
	
}