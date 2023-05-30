package com.koyotito.project.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Archivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArchivo;

	private String nombre;
	private String tipo;
	private String enlace;
	private boolean isPapelera;	
	@ManyToOne
	private Profesor profesor;
	
	@OneToMany(mappedBy = "archivo")
	private List<RelTarjetaArchivo> relTarjetaArchivos;

	public Archivo() {

	}

	public Archivo(Long idArchivo, String nombre, String tipo, String enlace, boolean isPapelera, Profesor profesor,
			List<RelTarjetaArchivo> relTarjetaArchivos) {
		super();
		this.idArchivo = idArchivo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.enlace = enlace;
		this.isPapelera = isPapelera;
		this.profesor = profesor;
		this.relTarjetaArchivos = relTarjetaArchivos;
	}

	@Override
	public String toString() {
		return "Archivo [idArchivo=" + idArchivo + ", nombre=" + nombre + ", tipo=" + tipo + ", enlace=" + enlace
				+ ", isPapelera=" + isPapelera + ", profesor=" + profesor + ", relTarjetaArchivos=" + relTarjetaArchivos
				+ "]";
	}

	public Long getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(Long idArchivo) {
		this.idArchivo = idArchivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public boolean isPapelera() {
		return isPapelera;
	}

	public void setPapelera(boolean isPapelera) {
		this.isPapelera = isPapelera;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<RelTarjetaArchivo> getRelTarjetaArchivos() {
		return relTarjetaArchivos;
	}

	public void setRelTarjetaArchivos(List<RelTarjetaArchivo> relTarjetaArchivos) {
		this.relTarjetaArchivos = relTarjetaArchivos;
	}
}
