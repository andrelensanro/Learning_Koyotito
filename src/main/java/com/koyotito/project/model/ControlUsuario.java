package com.koyotito.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class ControlUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idControlUsuario;
	private String motivo;

	@ManyToOne
	private Accion accion;
	@ManyToOne
	private Administrador administrador;
	@ManyToOne
	private Usuario usuario;

	public ControlUsuario() {
		
	}

	public ControlUsuario(Long idControlUsuario, String motivo, Accion accion, Administrador administrador,
			Usuario usuario) {
		super();
		this.idControlUsuario = idControlUsuario;
		this.motivo = motivo;
		this.accion = accion;
		this.administrador = administrador;
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "ControlUsuario [idControlUsuario=" + idControlUsuario + ", motivo=" + motivo + ", accion=" + accion
				+ ", administrador=" + administrador + ", usuario=" + usuario + "]";
	}

	public Long getIdControlUsuario() {
		return idControlUsuario;
	}

	public void setIdControlUsuario(Long idControlUsuario) {
		this.idControlUsuario = idControlUsuario;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Accion getAccion() {
		return accion;
	}

	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
