package com.koyotito.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Archivo;
import com.koyotito.project.repository.ArchivoRepo;

@Service
public class ArchivoService {
	@Autowired
	private ArchivoRepo archivoRepo;
	
	List<Archivo> findByProfesorIdProfesor(Long id){
		return archivoRepo.findByProfesorIdProfesor(id);
	}
	
	public Archivo save(Archivo archivo) {
		return archivoRepo.save(archivo);
	}
	public Archivo findById(Long id) {
		return archivoRepo.findById(id).get();
	}
	
	public void delete(Archivo a) {
		archivoRepo.delete(a);
	}
	
	public void deleteById(Long id) {
		archivoRepo.deleteById(id);
	}
}
