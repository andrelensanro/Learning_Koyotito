package com.koyotito.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Likes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idLike;
	
	@ManyToOne
	private Clase clase;
	
	@ManyToOne
	private Tutorado tutorado;
	
	@ManyToOne 
	private Profesor profesor;

	public Likes() {
		
	}
	public Likes(Long idLike, Clase clase, Tutorado tutorado, Profesor profesor) {
		super();
		this.idLike = idLike;
		this.clase = clase;
		this.tutorado = tutorado;
		this.profesor = profesor;
	}
	@Override
	public String toString() {
		return "Likes [idLike=" + idLike + ", clase=" + clase + ", tutorado=" + tutorado + ", profesor=" + profesor
				+ "]";
	}
	public Long getIdLike() {
		return idLike;
	}
	public void setIdLike(Long idLike) {
		this.idLike = idLike;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public Tutorado getTutorado() {
		return tutorado;
	}
	public void setTutorado(Tutorado tutorado) {
		this.tutorado = tutorado;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
}
