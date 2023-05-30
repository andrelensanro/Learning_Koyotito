package com.koyotito.project.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koyotito.project.model.Clase;
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
@CrossOrigin(origins = "http://localhost:4200")
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
	public void login(@RequestBody Usuario usuario){
		Usuario usr = usuarioService.findByCorreo(usuario.getCorreo());
		if(usr == null)
			logger.info("no existe ese correo registrado");
		else
			logger.info("Listo!");
	}
	
	@PostMapping("/registro")
	/*
	 *
	 * 
	 * 1 Administrador
	 * 2 Profesor
	 * 3 Tutor
	 * 
	 * */
	public Usuario registro(@RequestBody Usuario usuario) {

		Usuario usr = usuarioService.findByCorreo(usuario.getCorreo());
		if(usr == null) {
			int tipo = usuario.getIdTipoUsuario();
		
			if(tipo == 2){/*PROFESOR*/
				
				Profesor profesor = new Profesor();
				profesor.setInstitucion(usuario.getInstPseudonimo());
				profesorService.save(profesor);
				usuario.setProfesor(profesor);
			}else if(tipo == 3) { /*TUTOR*/
				Tutor tutor = new Tutor();
				tutor.setNumTutorados(1);
				usuario.setTutor(tutor);
				Tutorado tutorado = new Tutorado();
				tutorado.setPseudonimo(usuario.getInstPseudonimo());
				tutorado.setNivel(1);
				tutorado.setPuntos(10L); 
				tutorado.setTutor(tutor);
				tutorService.save(tutor);
				tutoradoService.save(tutorado);
			}			
			return usuarioService.save(usuario);
		}
		return usr;
	}
}
