package com.koyotito.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koyotito.project.model.RelTutoradoInvitacion;
import com.koyotito.project.model.Tag;

@Repository
public interface RelTutoradoInvitacionRepo extends JpaRepository<RelTutoradoInvitacion, Long>{
	List<RelTutoradoInvitacion> findByTutoradoIdTutorado(Long idTutorado);
}
