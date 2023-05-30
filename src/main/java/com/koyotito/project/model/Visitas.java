package com.koyotito.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Visitas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long idVisita;
	
	@ManyToOne
	private Tutorado tutorado;
	@ManyToOne
	private Profesor profesor;
	@ManyToOne
	private Clase clase;
	
	public Visitas() {

	}
	public Visitas(Long idVisita, Tutorado tutorado, Profesor profesor, Clase clase) {
		super();
		this.idVisita = idVisita;
		this.tutorado = tutorado;
		this.profesor = profesor;
		this.clase = clase;
	}
	@Override
	public String toString() {
		return "Visitas [idVisita=" + idVisita + ", tutorado=" + tutorado + ", profesor=" + profesor + ", clase="
				+ clase + "]";
	}
	public Long getIdVisita() {
		return idVisita;
	}
	public void setIdVisita(Long idVisita) {
		this.idVisita = idVisita;
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
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}	
}
