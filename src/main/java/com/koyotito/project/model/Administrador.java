package com.koyotito.project.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer idAdministrador;
	
	@OneToMany(mappedBy = "administrador")
	private List<ControlUsuario> controlUsuarios;
	
	@OneToOne(mappedBy = "administrador")
	private Usuario usuario;
		
	public Administrador() {
		
	}

	@Override
	public String toString() {
		return "Administrador [idAdministrador=" + idAdministrador + ", controlUsuarios=" + controlUsuarios + ", usuario="
				+ usuario + "]";
	}
	public Integer getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Integer idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public List<ControlUsuario> getControlUsuario() {
		return controlUsuarios;
	}

	public void setControlUsuario(List<ControlUsuario> controlUsuario) {
		this.controlUsuarios = controlUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Administrador(Integer idAdministrador, List<ControlUsuario> controlUsuarios, Usuario usuario) {
		super();
		this.idAdministrador = idAdministrador;
		this.controlUsuarios = controlUsuarios;
		this.usuario = usuario;
	}

	
	
		
}
