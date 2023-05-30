package com.koyotito.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.koyotito.project.model.Clase;
import com.koyotito.project.model.Visitas;

@Repository
public interface VisitaRepo extends JpaRepository<Visitas, Long> {
	
	@Query(value = "SELECT COUNT(*) from visitas where visitas.clase_idClase=:idClase", nativeQuery=true)
	public Long numVisitas(Long idClase);
	
	public List<Visitas> findByClaseIdClase(Long idClase);
	
}
