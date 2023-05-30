package com.koyotito.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.DenunciaClase;
import com.koyotito.project.repository.DenunciaRepo;

@Service
public class DenunciaService {
	@Autowired
	private DenunciaRepo denunciaRepo;
	
	public int numDenuncias(Long idClase) {
		return denunciaRepo.numDenuncias(idClase);
	}
	public DenunciaClase save(DenunciaClase denuncia) {
		return denunciaRepo.save(denuncia);
	}

	public void delete(DenunciaClase denuncia){
		denunciaRepo.delete(denuncia);
	}
	
	public void deleteById(Long id) {
		denunciaRepo.deleteById(id);
	}
	
	public List<DenunciaClase> findByClaseIdClase(Long id){
		return denunciaRepo.findByClaseIdClase(id);
	}
	
	public DenunciaClase findById(Long id) {
		Optional<DenunciaClase> denuncia = denunciaRepo.findById(id);
		if(denuncia.isPresent())
			return denuncia.get();
		return null;
	}


}
