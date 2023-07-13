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

	@RequestMapping(value = "usuarios")
	public List<Usuario> getUsuarios() {
		return usuarioDao.getUsuarios();
		
	}

}
