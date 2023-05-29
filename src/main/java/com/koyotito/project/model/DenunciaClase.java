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
	@Column(unique = true, nullable = false)
	private Integer idDenuncia;
	private String motivo;
	private Date fechaDenuncia;
	
	@ManyToOne
	private Clase clase; 
	@ManyToOne
	private Usuario usuario;
	
	public DenunciaClase() {
		
	}
	public DenunciaClase(Integer idDenuncia, String motivo, Date fechaDenuncia, Clase clase, Usuario usuario) {
		super();
		this.idDenuncia = idDenuncia;
		this.motivo = motivo;
		this.fechaDenuncia = fechaDenuncia;
		this.clase = clase;
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "DenunciaClase [idDenuncia=" + idDenuncia + ", motivo=" + motivo + ", fechaDenuncia=" + fechaDenuncia
				+ ", clase=" + clase + ", usuario=" + usuario + "]";
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Integer getIdDenuncia() {
		return idDenuncia;
	}
	public void setIdDenuncia(Integer idDenuncia) {
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
