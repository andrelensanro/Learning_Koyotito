package com.koyotito.project.services;

import org.springframework.stereotype.Service;

import com.koyotito.project.model.DenunciaClase;
import com.koyotito.project.repository.DenunciaRepo;

@Service
public class DenunciaService {
	private DenunciaRepo denunciaRepo;
	
	public DenunciaClase crear(DenunciaClase denuncia) {
		return denunciaRepo.save(denuncia);
	}

	public void eliminar(DenunciaClase denuncia){
		denunciaRepo.delete(denuncia);
	}
	



}
