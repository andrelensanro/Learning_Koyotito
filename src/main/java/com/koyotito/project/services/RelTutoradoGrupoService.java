package com.koyotito.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.RelTutoradoGrupo;
import com.koyotito.project.repository.RelTutoradoGrupoRepo;

@Service
public class RelTutoradoGrupoService {
	@Autowired
	private RelTutoradoGrupoRepo rtgRepo;
	
	public List<RelTutoradoGrupo> findByTutoradoIdTutorado(Long idTutorado){
		return rtgRepo.findByTutoradoIdTutorado(idTutorado);
	}
	
	
	public void delete(RelTutoradoGrupo r) {
		rtgRepo.delete(r);
	}
	
	public RelTutoradoGrupo save(RelTutoradoGrupo r) {
		return rtgRepo.save(r);
	}
	
	public RelTutoradoGrupo findById(Long id) {
		Optional<RelTutoradoGrupo> rtg = rtgRepo.findById(id);
		if(rtg.isPresent()) {
			return rtg.get();
		}
		return null;
	}
	
}
