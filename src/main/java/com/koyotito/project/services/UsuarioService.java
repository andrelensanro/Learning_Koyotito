package com.koyotito.project.services;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.controller.ClaseController;
import com.koyotito.project.model.Usuario;
import com.koyotito.project.repository.UsuarioRepo;

import ch.qos.logback.classic.Logger;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepo usuarioRepo;
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(ClaseController.class);
	
	public Optional<Usuario> findByCorreo(String email) {
		return usuarioRepo.findByCorreo(email);
	}
	public Optional<Usuario> findById(int id) {
		return usuarioRepo.findById(id);
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}
	public void delete(Usuario usuario) {
		usuarioRepo.delete(usuario);
	}	
	public void update(Usuario user) {
		usuarioRepo.save(user);
	}
}
