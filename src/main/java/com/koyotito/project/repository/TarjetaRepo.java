package com.koyotito.project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.koyotito.project.model.Tarjeta;

@Repository
public interface TarjetaRepo extends JpaRepository<Tarjeta, Long> {
//	@Query(value="SELECT idTarjeta "
//			+ "FROM tarjeta "
//			+ "WHERE tarjeta.clase_idClase = :idClase",  nativeQuery=true)
//	List<Integer> findByIdClase(@Param("idClase") int idClase); 
	
	List<Tarjeta> findByClaseIdClase(Long id);
	
}
