package com.koyotito.project.controller;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koyotito.project.model.Profesor;
import com.koyotito.project.model.Usuario;
import com.koyotito.project.services.ProfesorService;
import com.koyotito.project.services.UsuarioService;

import ch.qos.logback.classic.Logger;


@RestController
@RequestMapping("/profesor")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfesorController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ProfesorService profesorService;
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(ClaseController.class);
	
	@PutMapping("/cambiar-datos/{idUsuario}/")
	public Usuario cambiarDatos(@PathVariable("idUsuario") Long idUsuario, @RequestBody Usuario usuario){
		Usuario user = usuarioService.findById(idUsuario);
		return user;
	}
	
	@PostMapping("/cambiar-password")
	public Usuario cambiarDatos(
			@RequestBody String new_password){
		
		Long idUsuario = 2L;
		
		Usuario usr = usuarioService.findById(idUsuario);
		if(usr != null) {
			usr.setPassword(new_password);
			usuarioService.save(usr);
		}
		return usr;
	}
//	
//	@GetMapping("/{idProfesor}/ver-clases-gustan")
//	public List<Clase> clasesMeGusta(@PathVariable("idProfesor") Long idProfesor){
//		
//	}
//	
	
	
	

}
