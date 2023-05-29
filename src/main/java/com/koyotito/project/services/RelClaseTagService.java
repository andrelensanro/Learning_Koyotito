package com.koyotito.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.koyotito.project.model.RelClaseTag;
import com.koyotito.project.repository.RelClaseTagRepo;

@Service
public class RelClaseTagService {
	@Autowired
	private RelClaseTagRepo relclasetagRepo;
	
	public RelClaseTag save(RelClaseTag rel) {
		return relclasetagRepo.save(rel);
	}
	public void remove(RelClaseTag r){
		relclasetagRepo.delete(r);
	}
}
