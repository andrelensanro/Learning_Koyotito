package com.koyotito.project.services;

import java.util.Optional;

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
	
	public Tutor findById(Long id) {
		Optional<Tutor> tutor = tutorRepo.findById(id);
		if(tutor.isPresent())
			return tutor.get();
		return null;
	}
	
	public void delete(Tutor tutor) {
		tutorRepo.delete(tutor);
	}
	
	public void deleteById(Long id) {
		tutorRepo.deleteById(id);
	}
}
