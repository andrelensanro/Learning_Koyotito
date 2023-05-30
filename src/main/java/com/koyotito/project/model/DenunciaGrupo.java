package com.koyotito.project.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DenunciaGrupo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDenuncia;
	private String motivo;
	private Date fechaDenuncia;
	

	@ManyToOne
	private Grupo grupo;


	public DenunciaGrupo() {

	}
	
	public DenunciaGrupo(Long idDenuncia, String motivo, Date fechaDenuncia, Grupo grupo) {
		super();
		this.idDenuncia = idDenuncia;
		this.motivo = motivo;
		this.fechaDenuncia = fechaDenuncia;
		this.grupo = grupo;
		
	}

	@Override
	public String toString() {
		return "DenunciaGrupo [idDenuncia=" + idDenuncia + ", motivo=" + motivo + ", fechaDenuncia=" + fechaDenuncia
				+ ", grupo=" + grupo + "]";
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

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}
