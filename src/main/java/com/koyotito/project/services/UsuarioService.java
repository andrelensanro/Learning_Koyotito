package com.koyotito.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Usuario;
import com.koyotito.project.repository.UsuarioRepo;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepo usuarioRepo;

	
	public Optional<Usuario> findByCorreo(String email) {
		return usuarioRepo.findByCorreo(email);
	}
	public Usuario save(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}
	public void delete(Usuario usuario) {
		usuarioRepo.delete(usuario);
	}	
}
