package com.koyotito.project.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Clase;
import com.koyotito.project.repository.ClaseRepo;

@Service
public class ClaseService {
	@Autowired
	private ClaseRepo claseRepo;

	public Clase save(Clase clase) {
		return claseRepo.save(clase);
	}
	public Clase findById(int id) {
		return claseRepo.getReferenceById(id);
	}
//	public List<Clase> findByIdProfesor(int idProfesor){
//		return claseRepo.findByIdProfesor(idProfesor);
//	}
	private final Logger logger = LoggerFactory.getLogger(ClaseService.class);
	
	public List<String> findAll_nombreClase(){	
		return claseRepo.todasClases();
	}
	
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
	
	public List<String> findAll_institucion(String institucion){
		return claseRepo.todasClase_institucion(institucion);
	}
	
}
