package com.koyotito.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Archivo;
import com.koyotito.project.repository.ArchivoRepo;

@Service
public class ArchivoService {
	@Autowired
	private ArchivoRepo archivoRepo;
	
	public Archivo save(Archivo archivo) {
		return archivoRepo.save(archivo);
	}
	public Archivo findById(int id) {
		return archivoRepo.findById(id).get();
	}
}
