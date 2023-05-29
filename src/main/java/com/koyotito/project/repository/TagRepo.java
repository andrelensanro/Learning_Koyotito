package com.koyotito.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.koyotito.project.model.Tag;


@Repository
public interface TagRepo extends JpaRepository<Tag, Integer> {
	//public List<Tag> findAllTags();
	
}
