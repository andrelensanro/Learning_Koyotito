package com.koyotito.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.koyotito.project.model.Clase;
import com.koyotito.project.model.Likes;

@Repository
public interface LikesRepo extends JpaRepository<Likes, Long>{
	
	@Query(value = "SELECT COUNT(*) from likes where likes.clase_idClase=:idClase", nativeQuery=true)
	public Long numLikes(Long idClase);
	
	List<Likes> findByClaseIdClase(Long id);
	
	
}
