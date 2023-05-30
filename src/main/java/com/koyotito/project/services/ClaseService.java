package com.koyotito.project.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Clase;
import com.koyotito.project.model.RelClaseTag;
import com.koyotito.project.model.RelGrupoClase;
import com.koyotito.project.model.RelTarjetaArchivo;
import com.koyotito.project.repository.ClaseRepo;
import com.koyotito.project.repository.LikesRepo;
import com.koyotito.project.repository.RelClaseTagRepo;
import com.koyotito.project.repository.RelGrupoClaseRepo;
import com.koyotito.project.repository.RelTarjetaArchivoRepo;
import com.koyotito.project.repository.TarjetaRepo;

@Service
public class ClaseService {
	@Autowired
	private ClaseRepo claseRepo;
	@Autowired
	private LikesRepo likesRepo;
	@Autowired
	private RelTarjetaArchivoRepo relTarjetaArchivoRepo;
	@Autowired
	private TarjetaRepo tarjetaRepo;
	@Autowired
	private RelGrupoClaseRepo relGrupoClaseRepo;
	@Autowired
	private RelClaseTagRepo relClaseTagRepo;

	/*************FUNCIONES DE CONTROL DERIVADAS DEL REPO*****************/
	private final Logger logger = LoggerFactory.getLogger(ClaseService.class);

	public Clase save(Clase clase) {
		Clase c = new Clase();
		c = claseRepo.save(clase);
		return c;
	}
	public Clase findById(Long id) {
		Optional<Clase> op_clase = claseRepo.findById(id);
		if(op_clase.isPresent())
			return op_clase.get();
		else
			return null;
	}
	public void deleteById(Long id) {
		claseRepo.deleteById(id);
	}
	public void delete(Clase clase) {
		claseRepo.delete(clase);
	}
	
	public List<Clase> findByProfesorIdProfesor(Long id){
		return claseRepo.findByProfesorIdProfesor(id);
	}
	
	
	/************************************************************************/
	/**************** Query Nativa ******************************************/
	
	/*Regresa el nombre de todas las clases*/
	public List<String> findAll_nombreClase(){	
		return claseRepo.todasClases();
	}
	/*Regresa el nombre del profesor de todas las clases*/
	public List<String> findAll_profesor(String nombre){
		String[] nombres = nombre.split(" ");
		switch(nombres.length){
			case 1:
				logger.info(nombre + " tiene el tamaño " + nombres.length); 
				List<String> list = new ArrayList<>();
				list = claseRepo.todasClase_profesor(nombres[0],  "",  "");
				if(list.size()==0)
					list = claseRepo.todasClase_profesor("",  nombres[0],  "");
				if(list.size()==0)
					list = claseRepo.todasClase_profesor("", "", nombres[0]);
				return list;			
			case 2: 
				//List<String> list1 = new ArrayList<>();
				list = claseRepo.todasClase_profesor(nombres[0], nombres[1],  "");
				if(list.size()==0)
					list = claseRepo.todasClase_profesor(nombres[0], "", nombres[1]);
				if(list.size()==0)
					list = claseRepo.todasClase_profesor("", nombres[0], nombres[1]);
				return list;
			case 3:
				return claseRepo.todasClase_profesor(nombres[0],  nombres[1],  nombres[2]);
			default: break;
		}
		return claseRepo.todasClase_profesor(nombres[0],  "",  "");
	}
	/*Regresa las clases que tienen por institucion :institucion*/
	public List<String> findAll_institucion(String institucion){
		return claseRepo.todasClase_institucion(institucion);
	}
	
	/**********************************************************************************************/
	/*****************************************FUNCIONES REPETITIVAS********************************/
	
	public Date getFechaActual() {
		LocalDateTime hoy = LocalDateTime.now();  
        Instant instant = hoy.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        return date;
	}
	
}
