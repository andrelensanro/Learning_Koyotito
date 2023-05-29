package com.koyotito.project.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Tarjeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer idTarjeta;
	private String instruccion;
	private String clave;
	
	@OneToMany(mappedBy = "tarjeta")
	private List<RelTarjetaArchivo> relTarjetaArchivos;
	
	@ManyToOne
	private Clase clase;

	public Tarjeta() {

	}
	public Tarjeta(Integer idTarjeta, String instruccion, String clave, List<RelTarjetaArchivo> relTarjetaArchivos,
			Clase clase) {
		super();
		this.idTarjeta = idTarjeta;
		this.instruccion = instruccion;
		this.clave = clave;
		this.relTarjetaArchivos = relTarjetaArchivos;
		this.clase = clase;
	}
	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", instruccion=" + instruccion + ", clave=" + clave
				+ ", relTarjetaArchivo=" + relTarjetaArchivos + ", clase=" + clase + "]";
	}
	public Integer getIdTarjeta() {
		return idTarjeta;
	}
	public void setIdTarjeta(Integer idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public String getInstruccion() {
		return instruccion;
	}
	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public List<RelTarjetaArchivo> getRelTarjetaArchivo() {
		return relTarjetaArchivos;
	}
	public void setRelTarjetaArchivo(List<RelTarjetaArchivo> relTarjetaArchivo) {
		this.relTarjetaArchivos = relTarjetaArchivo;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}		
}
