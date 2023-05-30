package com.koyotito.project.services;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.controller.ClaseController;
import com.koyotito.project.model.Clase;
import com.koyotito.project.model.Usuario;
import com.koyotito.project.repository.UsuarioRepo;

import ch.qos.logback.classic.Logger;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepo usuarioRepo;
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(ClaseController.class);
	
	public Usuario save(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}
	
	public void update(Usuario user) {
		usuarioRepo.save(user);
	}
	
	
	public void delete(Usuario usuario) {
		usuarioRepo.delete(usuario);
	}
	
	public void deleteById(Long id) {
		usuarioRepo.deleteById(id);
	}
	
	public Usuario findByCorreo(String correo) {
		Usuario usr = new Usuario();
		usr = usuarioRepo.findByCorreo(correo);
		
		return usr;
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> op_usuario = usuarioRepo.findById(id);
		if(op_usuario.isPresent())
			return op_usuario.get();
		else
			return null;
	}
	public Long getId_profesor(Long idUsuario) {
		return usuarioRepo.getId_profesor(idUsuario);
	}
	
}
