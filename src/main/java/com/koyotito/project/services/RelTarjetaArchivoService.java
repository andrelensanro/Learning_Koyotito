package com.koyotito.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.RelTarjetaArchivo;
import com.koyotito.project.repository.RelTarjetaArchivoRepo;

@Service

public class RelTarjetaArchivoService {
	@Autowired
	private RelTarjetaArchivoRepo relRepo;
	
	public List<Integer> findByIdClase(int idClase){
		return relRepo.findByIdClase(idClase);
	}
	
	public void eliminarRel(RelTarjetaArchivo relacion) {
		relRepo.delete(relacion);
	}
	public RelTarjetaArchivo findById(int id) {
		return relRepo.findById(id).get();
	}

}
