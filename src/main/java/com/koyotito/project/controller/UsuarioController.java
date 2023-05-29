package com.koyotito.project.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koyotito.project.model.Profesor;
import com.koyotito.project.model.Tutor;
import com.koyotito.project.model.Tutorado;
import com.koyotito.project.model.Usuario;
import com.koyotito.project.services.ProfesorService;
import com.koyotito.project.services.TutorService;
import com.koyotito.project.services.TutoradoService;
import com.koyotito.project.services.UsuarioService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/usuario")
public class UsuarioController{
	
	private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	@Autowired
	ProfesorService profesorService;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	TutoradoService tutoradoService; 
	@Autowired
	TutorService tutorService;
	
	
	@PostMapping("/login")
	public Usuario login(@RequestBody Usuario usuario){
		Optional<Usuario> usr =  usuarioService.findByCorreo(usuario.getCorreo());
		if(usr.isPresent()) {
			return usr.get();
		}
		logger.info("este usuario no esta registrado");
		return null;
	}
	
	@PostMapping("/registro")
	public Usuario registro(@RequestBody Usuario usuario) {
		logger.info(usuario.toString());
	
		Optional<Usuario> usr = usuarioService.findByCorreo(usuario.getCorreo().toString());
		if(usr.isPresent()) {
			logger.warn("Ese email ya esta en la base de datos");
			return null;
		}
		int tipo = usuario.getIdTipoUsuario();
		if(tipo == 2){//PROFESOR
			Profesor profesor = new Profesor();
			profesor.setInstitucion(usuario.getInstPseudonimo());
			usuario.setProfesor(profesor);
			logger.info("Se agrego al profesor como usuario.");
			profesorService.save(profesor);
		}else if(tipo == 3) {
			Tutor tutor = new Tutor();
			tutor.setNumTutorados(1);
			usuario.setTutor(tutor);
			logger.info("Se ligo el tutor a un usuario.");
			Tutorado tutorado = new Tutorado();
			tutorado.setPseudonimo(usuario.getInstPseudonimo());
			tutorado.setNivel(1);
			tutorado.setPuntos(10);
			tutorado.setTutor(tutor);
			List<Tutorado> tutorados = new ArrayList<Tutorado>();
			tutorados.add(tutorado);
			tutor.setTutorados(tutorados);
			tutorService.save(tutor);
			tutoradoService.save(tutorado);
			logger.info("Se ligo el tutorado a su tutor");
		}else {
			logger.warn("Tipo de usuario no valido");
		}
		return usuarioService.save(usuario);
	}
	
	
	
}
