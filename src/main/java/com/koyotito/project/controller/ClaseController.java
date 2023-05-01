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
		int idProfesor = 2;
		Profesor profesor = profesorService.findById(idProfesor);
		if(profesor == null) {
			logger.warn("El profesor no existe,  la busqueda se realizo por id");
			return null;
		}
			
		Clase updateClase = new Clase();
		updateClase = claseService.findById(idClase);
		updateClase.setNombreClase(clase.getNombreClase());
		logger.info("ASIGNACION DE NOMBRE");

		Date d = new Date();
		Calendar c = new GregorianCalendar(); 
		c.setTime(d);

		String dia, mes, annio;
//		hora, minuto, segundo;

		dia = Integer.toString(c.get(Calendar.DATE));
		mes = Integer.toString(c.get(Calendar.MONTH));
		annio = Integer.toString(c.get(Calendar.YEAR));
//		hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
//		minuto = Integer.toString(c.get(Calendar.MINUTE));
//		segundo = Integer.toString(c.get(Calendar.SECOND));
		String fechaEdicion = annio + "-" + mes + "-" + dia; 
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
		Date fechaE;
		try {
			fechaE = formato.parse(fechaEdicion);
			updateClase.setFecha(fechaE);
			logger.info("ASIGNACION DE FECHA");
		} catch (ParseException e) {
			logger.error("Error en el parseo de la fecha");
		}
		
		updateClase.setEstado(clase.getEstado());
		updateClase.setNumTarjetas(clase.getNumTarjetas());
		updateClase.setNumVisitas(clase.getNumVisitas());
		updateClase.setNumMeGusta(clase.getNumMeGusta());
		updateClase.setNumDenuncias(clase.getNumDenuncias());
		updateClase.setPapelera(clase.getPapelera());
		updateClase.setVisitas(clase.getVisitas());
		updateClase.setLikes(clase.getLikes());
		updateClase.setDenuncias(clase.getDenuncias());
		updateClase.setRelGrupoClases(clase.getRelGrupoClases());
		updateClase.setRelTarjetaArchivos(clase.getRelTarjetaArchivos());
		
		updateClase.setProfesor(profesor);
		logger.info("ASIGNACION DE PARAMETROS VARIOS");
		
		Clase cla = new Clase();
		cla = claseService.save(updateClase);	
	
		List<RelClaseTag> relaciones =  claseService.findById(idClase).getRelClaseTags();
		for(RelClaseTag r : relaciones) {
			Tag t = new Tag();
			t = r.getTag();
			logger.info(t.getNombre());
			relclasetagService.remove(r);
			tagService.remove(t);
		}
		logger.info("ELIMINCACION DE LOS TAGS");
		
		List<RelClaseTag> rel = new ArrayList<>();
		rel = clase.getRelClaseTags();
		
		for(RelClaseTag r : rel) {
			Tag t = new Tag(); t = r.getTag();
			Tag tId = new Tag(); tId = tagService.save(t);
			r.setTag(tId);
			r.setClase(cla);
			relclasetagService.save(r);
		}
		logger.info("ASIGNACION DE TAGS");
		return cla;
		
	}
	
	

}
