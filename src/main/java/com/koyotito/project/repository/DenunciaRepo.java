package com.koyotito.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koyotito.project.model.DenunciaClase;


@Repository
public interface DenunciaRepo extends JpaRepository<DenunciaClase, Integer>{

}
