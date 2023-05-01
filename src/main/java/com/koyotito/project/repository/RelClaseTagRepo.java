package com.koyotito.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koyotito.project.model.RelClaseTag;



@Repository
public interface RelClaseTagRepo extends JpaRepository<RelClaseTag, Integer> {

}


