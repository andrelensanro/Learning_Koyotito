package com.koyotito.project.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.koyotito.project.model.Clase;
import com.koyotito.project.model.Usuario;
//import com.koyotito.project.repository.UsuarioRepo;
import com.koyotito.project.services.ClaseService;
import com.koyotito.project.services.UsuarioService;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(ClaseController.class);
	
	@Autowired
	private ClaseService claseService;
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("reestablecer")
	public void updatePass(@RequestBody Usuario usuario) {
		usuarioService.update(usuario);
	}
	
	
	@GetMapping("filtrar/tituloclase/{nombreClase}") 
	public List<String> filtrarNombreClase(@PathVariable String nombreClase, HttpSession session) {
		Optional<Usuario> usr = usuarioService.findById(Integer.parseInt(session.getAttribute("idUsuario").toString()));
		logger.info(usr.get().toString());
		return claseService.findAll_nombreClase().stream().filter(p -> p.toLowerCase().contains(nombreClase)).collect(Collectors.toList());
	}
	
	@GetMapping("filtrar/autor/{nombreAutor}")
	public List<String> filtrarNombreAutor(@PathVariable String nombreAutor){ //
		//String[] nombres = nombreAutor.split(" ");
		//String nombreAutor = "mauricio";
		logger.info(nombreAutor);
		return claseService.findAll_profesor(nombreAutor);// ().stream().filter(p -> p.toLowerCase().contains(nombreClase)).collect(Collectors.toList());	
	}
	
	@GetMapping("filtrar/institucion/{institucion}")
	public List<String> filtrarInstitucion(@PathVariable String institucion){
		return claseService.findAll_institucion(institucion);
	}
	
	
}
