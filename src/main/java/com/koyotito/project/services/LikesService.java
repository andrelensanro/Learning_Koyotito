package com.koyotito.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Clase;
import com.koyotito.project.model.Likes;
import com.koyotito.project.repository.LikesRepo;


@Service
public class LikesService{ 
	@Autowired
	private LikesRepo likesRepo;
	
	public Long numLikes(Long idClase) {
		return likesRepo.numLikes(idClase);
	}
	public List<Likes> findByClaseIdClase(Long id){
		return likesRepo.findByClaseIdClase(id);
	}
	
	public Likes findById(Long id) {
		Optional<Likes> likes = likesRepo.findById(id);
		if(likes.isPresent()) {
			return likes.get();
		}
		return null;
	}
	
	public void delete(Likes l) {
		likesRepo.delete(l);
	}
	
	public void deleteById(Long id) {
		likesRepo.deleteById(id);
	}
	
	public Likes save(Likes likes) {
		return likesRepo.save(likes);
	}
	
}
