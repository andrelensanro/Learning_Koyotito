package com.koyotito.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RelClaseTag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRelacion;
	
	@ManyToOne
	private Clase clase;
	@ManyToOne
	private Tag tag;

	public RelClaseTag() {
		
	}
	public RelClaseTag(Long idRelacion, Clase clase, Tag tag) {
		super();
		this.idRelacion = idRelacion;
		this.clase = clase;
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "RelClaseTag [idRelacion=" + idRelacion + ", clase=" + clase + ", tag=" + tag + "]";
	}
	public Long getIdRelacion() {
		return idRelacion;
	}
	public void setIdRelacion(Long idRelacion) {
		this.idRelacion = idRelacion;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
