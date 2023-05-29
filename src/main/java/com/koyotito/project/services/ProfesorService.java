package com.koyotito.project.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Profesor;
import com.koyotito.project.repository.ProfesorRepo;

@Service
public class ProfesorService {
	@Autowired
	private ProfesorRepo profesorRepo; 
	
	public Profesor save(Profesor profesor) {
		return profesorRepo.save(profesor);
	}
	public Profesor findById(int id) {
		return profesorRepo.getReferenceById(id);
	}
}
