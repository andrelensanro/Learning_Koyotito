package com.koyotito.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Profesor;
import com.koyotito.project.model.Usuario;
import com.koyotito.project.repository.ProfesorRepo;

@Service
public class ProfesorService {
	@Autowired
	private ProfesorRepo profesorRepo; 
	
	public Profesor save(Profesor profesor) {
		return profesorRepo.save(profesor);
	}
	public Profesor findById(Long id) {
		Optional<Profesor> profesor = profesorRepo.findById(id);
		if(profesor.isPresent())
			return profesor.get();
		return null;
	}
	
	public void delete(Profesor profesor) {
		profesorRepo.delete(profesor);
	}
	
	public void deleteById(Long id) {
		profesorRepo.deleteById(id);
	}


}
