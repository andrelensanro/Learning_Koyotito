package com.koyotito.project.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne; 

@Entity
public class DenunciaClase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idDenuncia;
	private String motivo;
	private Date fechaDenuncia;
	
	@ManyToOne
	private Clase clase; 

	
	public DenunciaClase() {
		
	}
	
	public DenunciaClase(Long idDenuncia, String motivo, Date fechaDenuncia, Clase clase) {
		super();
		this.idDenuncia = idDenuncia;
		this.motivo = motivo;
		this.fechaDenuncia = fechaDenuncia;
		this.clase = clase;
		
	}
	@Override
	public String toString() {
		return "DenunciaClase [idDenuncia=" + idDenuncia + ", motivo=" + motivo + ", fechaDenuncia=" + fechaDenuncia
				+ ", clase=" + clase + "]";
	}

	public Long getIdDenuncia() {
		return idDenuncia;
	}
	public void setIdDenuncia(Long idDenuncia) {
		this.idDenuncia = idDenuncia;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Date getFechaDenuncia() {
		return fechaDenuncia;
	}
	public void setFechaDenuncia(Date fechaDenuncia) {
		this.fechaDenuncia = fechaDenuncia;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}	
}
