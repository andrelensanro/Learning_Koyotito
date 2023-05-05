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

import com.koyotito.project.model.Archivo;
import com.koyotito.project.model.Clase;
import com.koyotito.project.model.Profesor;
import com.koyotito.project.model.RelClaseTag;
import com.koyotito.project.model.RelTarjetaArchivo;
import com.koyotito.project.model.Tag;
import com.koyotito.project.model.Tarjeta;
import com.koyotito.project.services.ArchivoService;
import com.koyotito.project.services.ClaseService;
import com.koyotito.project.services.ProfesorService;
import com.koyotito.project.services.RelClaseTagService;
import com.koyotito.project.services.RelTarjetaArchivoService;
import com.koyotito.project.services.TagService;
import com.koyotito.project.services.TarjetaService;
import com.koyotito.project.services.UsuarioService;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpSession;

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
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private RelTarjetaArchivoService reltaService ;
	@Autowired
	private TarjetaService tarjetaService;
	@Autowired
	private ArchivoService archivoService;
	
	@PostMapping("/crear")
	public Clase crear(@RequestBody Clase clase, HttpSession session) {
		// la implementacion de la siguiente linea es por si el front no me da el id del profesor 
		int idProfesor = usuarioService.getId_profesor(Integer.parseInt(session.getAttribute("idUsuario").toString()));
		Profesor profesor = new Profesor();
		profesor = profesorService.findById(idProfesor);
		clase.setProfesor(profesor);
		return claseService.save(clase);
	}
	
	
	@GetMapping("/edit/{idClase}") 
	public Clase edit(@PathVariable Integer idClase,  @RequestBody Clase clase) {
		// la obtencion del ID del profesor, se hara a partir de la obtencion del id de usuario y de lo que recoja la session 
		int idProfesor = 2;
		Profesor profesor = profesorService.findById(idProfesor);
		if(profesor == null) {
			logger.warn("Problema interno - El profesor no existe,  la busqueda se realizo por id");
			return null;
		}
			
		Clase updateClase = new Clase();
		updateClase = claseService.findById(idClase);
		updateClase.setNombreClase(clase.getNombreClase());
		logger.info("ASIGNACION DE NOMBRE");

		// fecha de edicion
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
		updateClase.setNumMeGusta(clase.getNumMeGusta());
		updateClase.setNumTarjetas(clase.getNumTarjetas());
		updateClase.setNumVisitas(clase.getNumVisitas());
		updateClase.setNumDenuncias(clase.getNumDenuncias());
		updateClase.setPapelera(clase.getPapelera());
		updateClase.setVisitas(clase.getVisitas());
		updateClase.setLikes(clase.getLikes());
		updateClase.setProfesor(profesor);
		updateClase.setDenuncias(clase.getDenuncias());
		updateClase.setRelGrupoClases(clase.getRelGrupoClases());
		logger.info("ASIGNACION DE PARAMETROS VARIOS");
		
		// eliminacion de las relaciones que ya existian
		
		List<Integer> relTA = new ArrayList<>();
		relTA = reltaService.findByIdClase(idClase);
		for(int x: relTA) {
			RelTarjetaArchivo r = new RelTarjetaArchivo();
			r = reltaService.findById(x);
			reltaService.eliminarRel(r);
		}
		List<Integer> tarj = new ArrayList<>();
		tarj = tarjetaService.findByIdClase(idClase);
		for(int x: relTA) {
			Tarjeta t = new Tarjeta();
			t = tarjetaService.findById(x);
			tarjetaService.delete(t);
		}
		
		Clase cla = new Clase();
		cla = claseService.save(updateClase);	
		
		// creacion y relacionar 
		
		List<RelTarjetaArchivo> relacionTA = clase.getRelTarjetaArchivos();
		List<Tarjeta> tarjetas = clase.getTarjetas();
		for(RelTarjetaArchivo r : relacionTA) {
			r.setClase(cla);
			Archivo a = new Archivo();
			a = r.getArchivo();
			r.setArchivo(a);
		}
	
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
		logger.info("Actualizacion de los tags");
		return cla;
	}
	
	

}
