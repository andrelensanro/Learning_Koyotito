package com.koyotito.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

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
import com.koyotito.project.model.RelClaseTag;
import com.koyotito.project.model.Tag;
import com.koyotito.project.services.ClaseService;
import com.koyotito.project.services.ProfesorService;
import com.koyotito.project.services.RelClaseTagService;
import com.koyotito.project.services.TagService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/clase")
@CrossOrigin(origins = "http://localhost:4200")
public class ClaseController {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(ClaseController.class);
	
	@Autowired
	private ProfesorService profesorService;
	@Autowired
	private ClaseService claseService;
	@Autowired
	private RelClaseTagService relclasetagService;
	@Autowired
	private TagService tagService;
	
	@PostMapping("/crear")
	public Clase crear(@RequestBody Clase clase) {
		/*int idProfesor = 4;
		
		*/
		int idProfesor = clase.getProfesor().getIdProfesor();
		Profesor profesor = new Profesor();
		profesor = profesorService.findById(idProfesor);
		clase.setProfesor(profesor);
		return claseService.save(clase);
	}
	
	
	@GetMapping("/edit/{idClase}") 
	public Clase edit(@PathVariable Integer idClase,  @RequestBody Clase clase) {
		logger.info("*******************************************");
		logger.info(idClase.toString());
		logger.info(clase.toString());
		logger.info("*******************************************");
		
		
		
		
		return clase;
		
	}
	
	

}
