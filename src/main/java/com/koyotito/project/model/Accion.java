package com.koyotito.project.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Accion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer idAccion;
	private String accion;

	
	@OneToMany(mappedBy = "accion")
	private List<ControlUsuario> controlUsuarios;
	
	public Accion() {	
	}
	public Accion(Integer idAccion, String accion) {
		super();
		this.idAccion = idAccion;
		this.accion = accion;
	}
	@Override
	public String toString() {
		return "Accion [idAccion=" + idAccion + ", accion=" + accion + "]";
	}
	public Integer getIdAccion() {
		return idAccion;
	}
	public void setIdAccion(Integer idAccion) {
		this.idAccion = idAccion;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public List<ControlUsuario> getControlUsuario() {
		return controlUsuarios;
	}
	public void setControlUsuario(List<ControlUsuario> controlUsuarios) {
		this.controlUsuarios = controlUsuarios;
	}
	
	
}
