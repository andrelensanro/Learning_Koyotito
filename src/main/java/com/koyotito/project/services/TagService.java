package com.koyotito.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koyotito.project.model.Clase;
import com.koyotito.project.model.Tag;
import com.koyotito.project.repository.TagRepo;

@Service
public class TagService {
	
	@Autowired
	private TagRepo tagRepo;
	
	public List<Tag> findAll(){
		return tagRepo.findAll();
	}
	public Tag findById(Long id) {
		Optional<Tag> op_tag = tagRepo.findById(id);
		if(op_tag.isPresent())
			return op_tag.get();
		else
			return null;
	}
	public Tag save(Tag tag) {
		return tagRepo.save(tag);
	}
	public void delete(Tag tag) {
		tagRepo.delete(tag);
	}
	
	public void deleteById(Long id) {
		tagRepo.deleteById(id);
	}
	
	public List<String> getAllTagsNombre(){
		return tagRepo.getAllTagsNombre();
	}
	
	public Long getIdTag_Nombre(String nombre){
		return tagRepo.getIdTag_Nombre(nombre);
	} 
	
	public String quitarEspaciosBlanco(String str) {
		String res = "";
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)!=' ')
				res+=str.charAt(i);
		}
		return res;
	}
	
}
