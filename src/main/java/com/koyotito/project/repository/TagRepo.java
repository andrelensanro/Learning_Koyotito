package com.koyotito.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.koyotito.project.model.Tag;


@Repository
public interface TagRepo extends JpaRepository<Tag, Long> {
	//public List<Tag> findAllTags();
	
	@Query(value = "SELECT DISTINCT nombre FROM tag", nativeQuery = true)
	public List<String> getAllTagsNombre();
	
	@Query(value = "SELECT idTag FROM tag where nombre=:nombre", nativeQuery=true)
	public Long getIdTag_Nombre(String nombre);
}
