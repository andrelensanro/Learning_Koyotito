package com.koyotito.project.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Invitaciones {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_invitacion;
	private String url_invitacion;
	
	@OneToMany(mappedBy = "invitacion")
	private List<RelTutoradoInvitacion> relaciones;

	
	public Invitaciones(){
		
	}
		
	public Invitaciones(Long id_invitacion, String url_invitacion, List<RelTutoradoInvitacion> relaciones) {
		super();
		this.id_invitacion = id_invitacion;
		this.url_invitacion = url_invitacion;
		this.relaciones = relaciones;
	}

	@Override
	public String toString() {
		return "Invitaciones [id_invitacion=" + id_invitacion + ", url_invitacion=" + url_invitacion + "]";
	}

	public Long getId_invitacion() {
		return id_invitacion;
	}

	public void setId_invitacion(Long id_invitacion) {
		this.id_invitacion = id_invitacion;
	}

	public String getUrl_invitacion() {
		return url_invitacion;
	}

	public void setUrl_invitacion(String url_invitacion) {
		this.url_invitacion = url_invitacion;
	}
	
	
	
	
	
}
