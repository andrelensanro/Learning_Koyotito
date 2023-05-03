package com.koyotito.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.koyotito.project.model.RelTarjetaArchivo;


@Repository
public interface RelTarjetaArchivoRepo extends JpaRepository<RelTarjetaArchivo, Integer>{
	
	@Query(value="SELECT idRelacion "
			+ "FROM RelTarjetaArchivo r "
			+ "WHERE r.clase_idClase = :idClase", nativeQuery = true)
	public List<Integer> findByIdClase(int idClase);
	

	
}
