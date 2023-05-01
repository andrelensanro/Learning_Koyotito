package com.koyotito.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Tag;
import com.koyotito.project.repository.TagRepo;

@Service
public class TagService {
	
	@Autowired
	private TagRepo tagRepo;
	
	public List<Tag> findAllTags(){
		return tagRepo.findAll();
	}
	public Tag save(Tag tag) {
		return tagRepo.save(tag);
	}
	public void remove(Tag tag) {
		tagRepo.delete(tag);
		return;
	}
}
