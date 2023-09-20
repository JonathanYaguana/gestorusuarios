package com.getordeusuarios.getorusuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.getordeusuarios.getorusuarios.dao.UsuarioDao;
import com.getordeusuarios.getorusuarios.models.Usuario;
import com.getordeusuarios.getorusuarios.utils.JWTUtil;

@RestController
public class AuthController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("api/login")
	public String login(@RequestBody Usuario usuario) {
		
		Usuario usuariologueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
		
		if(usuariologueado != null) {
			
			String tokenJWT = jwtUtil.create(String.valueOf(usuariologueado.getId()), usuariologueado.getEmail());
			
			return tokenJWT;
		}
		return "FAIL";
	}
}
