package com.koyotito.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Tarjeta;
import com.koyotito.project.repository.TarjetaRepo;

@Service
public class TarjetaService {
	@Autowired
	private TarjetaRepo tarjetaRepo;
	
	public List<Integer> findByIdClase(int idClase){
		return tarjetaRepo.findByIdClase(idClase);
	}
	
	public Tarjeta save(Tarjeta tarjeta) {
		return tarjetaRepo.save(tarjeta);
	}
	
	public void delete(Tarjeta tarjeta) {
		tarjetaRepo.delete(tarjeta);
	}
	public Tarjeta findById(int id) {
		return tarjetaRepo.findById(id).get();
	}
	
	
}
