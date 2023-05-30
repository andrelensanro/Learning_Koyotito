package com.koyotito.project.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.koyotito.project.model.RelClaseTag;



@Repository
public interface RelClaseTagRepo extends JpaRepository<RelClaseTag, Long> {

	List<RelClaseTag> findByClaseIdClase(Long id);
}


