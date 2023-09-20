package com.getordeusuarios.getorusuarios.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.getordeusuarios.getorusuarios.dao.UsuarioDao;
import com.getordeusuarios.getorusuarios.models.Usuario;
import com.getordeusuarios.getorusuarios.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private JWTUtil jwtUtil;

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
	
	private boolean validarToken(String token) {
		String usuarioId = jwtUtil.getKey(token);
		return usuarioId != null;
	}
	
	@GetMapping("api/usuarios")
	public List<Usuario> getUsuarios(@RequestHeader(value="Authorization") String token) {
		
		if(!validarToken(token)) {
			return null;
		}
		
		return usuarioDao.getUsuarios();
	}
	
	@DeleteMapping("api/usuarios/{Id}")
	public void eliminarUsuario(@RequestHeader(value="Authorization") String token,
			@PathVariable Long Id) {
		if (!validarToken(token)) {
			return;
		}
		usuarioDao.eliminar(Id);		
	}
	
	@PostMapping(value = "api/usuarios")
	public void regitrarUsuario(@RequestBody Usuario usuario) {
		
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
		
		usuario.setPassword(hash);
		
		usuarioDao.registrar(usuario);
	}

}
