package com.koyotito.project.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer idTag;
	private String nombre;
	
	@OneToMany(mappedBy = "tag")
	private List<RelClaseTag> relClaseTags;
	
	public Tag() {

	}
	public Tag(Integer idTag, String nombre, List<RelClaseTag> relClaseTags) {
		super();
		this.idTag = idTag;
		this.nombre = nombre;
		this.relClaseTags = relClaseTags;
	}
	@Override
	public String toString() {
		return "Tag [idTag=" + idTag + ", nombre=" + nombre + ", relClaseTags=" + relClaseTags + "]";
	}
	public Integer getIdTag() {
		return idTag;
	}
	public void setIdTag(Integer idTag) {
		this.idTag = idTag;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<RelClaseTag> getRelClaseTags() {
		return relClaseTags;
	}
	public void setRelClaseTags(List<RelClaseTag> relClaseTags) {
		this.relClaseTags = relClaseTags;
	}	
}
