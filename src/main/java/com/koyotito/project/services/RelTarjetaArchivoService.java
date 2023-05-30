package com.koyotito.project.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.koyotito.project.model.RelTarjetaArchivo;
import com.koyotito.project.repository.RelTarjetaArchivoRepo;

@Service
public class RelTarjetaArchivoService {
	@Autowired
	private RelTarjetaArchivoRepo relRepo;
	
	public RelTarjetaArchivo save(RelTarjetaArchivo rel){
		return relRepo.save(rel);
	}
	
	public void delete(RelTarjetaArchivo relacion) {
		relRepo.delete(relacion);
	}
	
	public void deleteById(Long id) {
		relRepo.deleteById(id);
	}
	
	public RelTarjetaArchivo findById(Long id) {
		Optional<RelTarjetaArchivo> rel = relRepo.findById(id);
		if(rel.isPresent()) {
			return rel.get();
		}
		return null;
	}
	
	public List<RelTarjetaArchivo> findByClaseIdClase(Long idClase){
		return relRepo.findByClaseIdClase(idClase);
	}

}
