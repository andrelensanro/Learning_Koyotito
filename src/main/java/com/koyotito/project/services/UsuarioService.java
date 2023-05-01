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
	public Usuario save(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}
	public void delete(Usuario usuario) {
		usuarioRepo.delete(usuario);
	}	
	public Usuario update(Usuario user) {
		Usuario u = new Usuario();
		u = usuarioRepo.getReferenceById(user.getIdUsuario());
		u.setNombre(user.getNombre());
		u.setApellido1(user.getApellido1());
		u.setApellido2(user.getApellido2());
		u.setPassword(user.getPassword() );
		u.setNum_denuncias(user.getNum_denuncias());
		logger.info("actualizacion de usuario " + u.toString());
		return u;
	}
}
