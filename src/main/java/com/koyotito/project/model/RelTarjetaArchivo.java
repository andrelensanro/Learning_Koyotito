package com.koyotito.project.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RelTarjetaArchivo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idRelacion;  
	@ManyToOne 
	private Clase clase;
	@ManyToOne
	private Tarjeta tarjeta;
	@ManyToOne
	private Archivo archivo;
	
	public RelTarjetaArchivo() {
		
	}
	public RelTarjetaArchivo(Long idRelacion, Clase clase, Tarjeta tarjeta, Archivo archivo) {
		super();
		this.idRelacion = idRelacion;
		this.clase = clase;
		this.tarjeta = tarjeta;
		this.archivo = archivo;
	}
	
	
	@Override
	public String toString() {
		return "RelTarjetaArchivo [idRelacion=" + idRelacion + ", clase=" + clase + ", tarjeta=" + tarjeta
				+ ", archivo=" + archivo + "]";
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
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	public Archivo getArchivo() {
		return archivo;
	}
	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}
	
}
