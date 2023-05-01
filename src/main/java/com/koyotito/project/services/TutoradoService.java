package com.koyotito.project.services;

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
}
