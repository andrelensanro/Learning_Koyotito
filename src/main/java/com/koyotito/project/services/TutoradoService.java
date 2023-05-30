package com.koyotito.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Tutorado;
import com.koyotito.project.repository.TutoradoRepo;

@Service
public class TutoradoService {
	@Autowired
	private TutoradoRepo tutoradoRepo;
	
	public Tutorado save(Tutorado tutorado) {
		return tutoradoRepo.save(tutorado);
	}
	
	public Tutorado findById(Long id) {
		Optional<Tutorado> tutorado = tutoradoRepo.findById(id);
		if(tutorado.isPresent()) {
			return tutorado.get();
		}
		return null;
	}
	public void delete(Tutorado tutorado) {
		tutoradoRepo.delete(tutorado);
	}
	
	public void deleteById(Long id) {
		tutoradoRepo.deleteById(id);
	}
	
}
