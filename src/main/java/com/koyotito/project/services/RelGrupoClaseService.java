package com.koyotito.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.RelGrupoClase;
import com.koyotito.project.repository.RelGrupoClaseRepo;

@Service
public class RelGrupoClaseService {

	@Autowired
	private RelGrupoClaseRepo relgrupoclaseRepo;
	
	public RelGrupoClase save(RelGrupoClase rel) {
		return relgrupoclaseRepo.save(rel);
	}
	
	public void delete(RelGrupoClase rel) {
		relgrupoclaseRepo.delete(rel);
	}
	
	public void deleteById(Long idRelacion) {
		relgrupoclaseRepo.deleteById(idRelacion);
	}
	
	public List<RelGrupoClase> findByClaseIdClase(Long idClase){
		return relgrupoclaseRepo.findByClaseIdClase(idClase);
	}
	
}
