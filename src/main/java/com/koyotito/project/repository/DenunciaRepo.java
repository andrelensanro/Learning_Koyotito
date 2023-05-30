package com.koyotito.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.koyotito.project.model.DenunciaClase;


@Repository
public interface DenunciaRepo extends JpaRepository<DenunciaClase, Long>{
	
	@Query(value = "SELECT COUNT(*) from denunciaclase where denunciaclase.clase_idClase=:idClase", nativeQuery=true)
	public int numDenuncias(Long idClase);

	List<DenunciaClase> findByClaseIdClase(Long id);
}
