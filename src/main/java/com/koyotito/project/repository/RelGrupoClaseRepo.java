package com.koyotito.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koyotito.project.model.RelGrupoClase;

@Repository
public interface RelGrupoClaseRepo extends JpaRepository<RelGrupoClase, Long> {
	
	List<RelGrupoClase> findByClaseIdClase(Long id);
	
}
