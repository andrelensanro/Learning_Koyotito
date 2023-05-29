package com.koyotito.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RelGrupoClase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer idRelacion;
	@ManyToOne
	private Grupo grupo;
	@ManyToOne
	private Clase clase;
	
	public RelGrupoClase() {

	}

	public RelGrupoClase(Integer idRelacion, Grupo grupo, Clase clase) {
		super();
		this.idRelacion = idRelacion;
		this.grupo = grupo;
		this.clase = clase;
	}

	@Override
	public String toString() {
		return "RelGrupoClase [idRelacion=" + idRelacion + ", grupo=" + grupo + ", clase=" + clase + "]";
	}

	public Integer getIdRelacion() {
		return idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}
	
}
