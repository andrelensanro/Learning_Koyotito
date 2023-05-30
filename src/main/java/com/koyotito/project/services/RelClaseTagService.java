package com.koyotito.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.koyotito.project.model.RelClaseTag;
import com.koyotito.project.repository.RelClaseTagRepo;

@Service
public class RelClaseTagService {
	@Autowired
	private RelClaseTagRepo relclasetagRepo;
	
	public RelClaseTag save(RelClaseTag rel) {
		 RelClaseTag r = new RelClaseTag();
		 return relclasetagRepo.save(rel);
		  
	}
	
	public void delete(RelClaseTag r){
		relclasetagRepo.delete(r);
	}
	
	public void deleteById(Long id) {
		relclasetagRepo.deleteById(id);
	}
	
	public RelClaseTag findById(Long id) {
		Optional<RelClaseTag> op_rel = relclasetagRepo.findById(id);
		if(op_rel.isPresent())
			return op_rel.get();
		else
			return null; 
	}
	
	public List<RelClaseTag> findByClaseIdClase(Long id){
		return relclasetagRepo.findByClaseIdClase(id);
	}
	
	
}
