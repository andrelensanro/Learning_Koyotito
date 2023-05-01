package com.koyotito.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Tutor;
import com.koyotito.project.repository.TutorRepo;

@Service
public class TutorService {
	@Autowired
	private TutorRepo tutorRepo;
	
	public Tutor save(Tutor tutor) {
		return tutorRepo.save(tutor);
	}
	
	
}
