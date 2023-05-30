package com.koyotito.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Clase;
import com.koyotito.project.model.Visitas;
import com.koyotito.project.repository.VisitaRepo;

@Service
public class VisitaService {
	@Autowired
	private VisitaRepo visitaRepo;
	
	public Long numVisitas(Long idClase) {
		return visitaRepo.numVisitas(idClase);
	}
	
	public Visitas save(Visitas v) {
		return visitaRepo.save(v);
	}
	
	public void delete(Visitas v) {
		visitaRepo.delete(v);
	}
	
	public void deleteById(Long id) {
		visitaRepo.deleteById(id);
	}

	public Visitas findById(Long id) {
		Optional<Visitas> visita = visitaRepo.findById(id);
		if(visita.isPresent()) {
			return visita.get();
		}
		return null;
	}

	public List<Visitas> findByClaseIdClase(Long idClase){
		return visitaRepo.findByClaseIdClase(idClase);
	}
}
