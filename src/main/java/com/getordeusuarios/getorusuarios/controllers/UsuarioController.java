package com.getordeusuarios.getorusuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getordeusuarios.getorusuarios.dao.UsuarioDao;
import com.getordeusuarios.getorusuarios.models.Usuario;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;

	@GetMapping("api/usuarios/{Id}")
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
	
	@GetMapping("api/usuarios")
	public List<Usuario> getUsuarios() {
		return usuarioDao.getUsuarios();
	}
	
	@DeleteMapping("api/usuarios/{Id}")
	public void eliminarUsuario(@PathVariable Long Id) {
		usuarioDao.eliminar(Id);		
	}
	
	@PostMapping(value = "api/usuarios")
	public void regitrarUsuario(@RequestBody Usuario usuario) {
		usuarioDao.registrar(usuario);
	}

}
