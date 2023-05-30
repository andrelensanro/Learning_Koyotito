package com.koyotito.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.RelTutoradoInvitacion;
import com.koyotito.project.repository.RelTutoradoInvitacionRepo;

@Service
public class RelTutoradoInvitacionService {
	@Autowired
	private RelTutoradoInvitacionRepo rtiRepo;
	
	public RelTutoradoInvitacion save(RelTutoradoInvitacion rti) {
		return rtiRepo.save(rti);
	}
	
	public RelTutoradoInvitacion findById(Long id) {
		Optional<RelTutoradoInvitacion> rti =  rtiRepo.findById(id);
		if(rti.isPresent()) {
			return rti.get();
		}
		return null;
	}
	
	public void delete(RelTutoradoInvitacion rti) {
		rtiRepo.delete(rti);
	}
	
	public List<RelTutoradoInvitacion> findByTutoradoIdTutorado(Long idTutorado) {
		return rtiRepo.findByTutoradoIdTutorado(idTutorado);
	}
	
	
	
}
