package com.koyotito.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koyotito.project.model.Tutor;

@Repository
public interface TutorRepo extends JpaRepository<Tutor, Long>{
	
}
