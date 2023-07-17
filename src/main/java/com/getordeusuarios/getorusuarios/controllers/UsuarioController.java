package com.getordeusuarios.getorusuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.getordeusuarios.getorusuarios.dao.UsuarioDao;
import com.getordeusuarios.getorusuarios.models.Usuario;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;

	@RequestMapping(value = "api/usuarios/{Id}", method = RequestMethod.GET)
	public Usuario getUsuarios(@PathVariable Long Id) {
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setNombre("jiji");
		usuario.setApellido("cc");
		usuario.setEmail("ji@gmail.com");
		usuario.setTelefono("099999");
		usuario.setPassword("98765");
		return usuario;
	}
	
	@RequestMapping(value = "api/usuarios")
	public List<Usuario> getUsuarios() {
		return usuarioDao.getUsuarios();
	}
	
	@RequestMapping(value = "api/usuarios/{Id}", method = RequestMethod.DELETE)
	public void eliminarUsuario(@PathVariable Long Id) {
		usuarioDao.eliminar(Id);		
	}

}
