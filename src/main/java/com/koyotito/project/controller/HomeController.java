package com.koyotito.project.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koyotito.project.model.Clase;
import com.koyotito.project.services.ClaseService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/")
public class HomeController {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(ClaseController.class);
	
	@Autowired
	private ClaseService claseService;
	
	@GetMapping("filtrar/tituloclase/{nombreClase}") 
	public List<String> filtrarNombreClase(@PathVariable String nombreClase) {
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
