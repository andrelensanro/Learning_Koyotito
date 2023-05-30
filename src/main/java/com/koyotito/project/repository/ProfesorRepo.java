package com.koyotito.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.koyotito.project.model.Profesor;
import com.koyotito.project.model.Usuario;

@Repository
public interface ProfesorRepo extends JpaRepository<Profesor, Long> {
	
	
}
