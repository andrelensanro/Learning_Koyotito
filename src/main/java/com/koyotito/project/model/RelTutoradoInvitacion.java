package com.koyotito.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RelTutoradoInvitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Tutorado tutorado;
	@ManyToOne
	private Invitaciones invitacion;
	
	
	public RelTutoradoInvitacion() {
		
	}
	
	public RelTutoradoInvitacion(Long id, Tutorado tutorado, Invitaciones invitacion) {
		super();
		this.id = id;
		this.tutorado = tutorado;
		this.invitacion = invitacion;
	}
	
	@Override
	public String toString() {
		return "RelTutoradoInvitacion [id=" + id + ", tutorado=" + tutorado + ", invitacion=" + invitacion + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Tutorado getTutorado() {
		return tutorado;
	}
	public void setTutorado(Tutorado tutorado) {
		this.tutorado = tutorado;
	}
	public Invitaciones getInvitacion() {
		return invitacion;
	}
	public void setInvitacion(Invitaciones invitacion) {
		this.invitacion = invitacion;
	}
	
	
	
}
