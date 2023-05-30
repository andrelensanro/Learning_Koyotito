package com.koyotito.project.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Grupo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGrupo;
	private String nombreGrupo;
	private Date fechaCreacion;
	@ManyToOne
	private Profesor profesor;
	@OneToMany(mappedBy = "grupo")
	private List<DenunciaGrupo> denunciaGrupos;
	@OneToMany(mappedBy = "grupo")
	private List<RelTutoradoGrupo> relUsuarioGrupos;
	@OneToMany(mappedBy = "grupo")
	private List<RelGrupoClase> relGrupoClases;
	@OneToOne
	private Invitaciones invitacion;
	
	
	public Grupo() {

	}

	public Grupo(Long idGrupo, String nombreGrupo, Date fechaCreacion, Profesor profesor,
			List<DenunciaGrupo> denunciaGrupos, List<RelTutoradoGrupo> relUsuarioGrupos,
			List<RelGrupoClase> relGrupoClases) {
		super();
		this.idGrupo = idGrupo;
		this.nombreGrupo = nombreGrupo;
		this.fechaCreacion = fechaCreacion;
		this.profesor = profesor;
		this.denunciaGrupos = denunciaGrupos;
		this.relUsuarioGrupos = relUsuarioGrupos;
		this.relGrupoClases = relGrupoClases;
	}

	@Override
	public String toString() {
		return "Grupo [idGrupo=" + idGrupo + ", nombreGrupo=" + nombreGrupo + ", fechaCreacion=" + fechaCreacion
				+ ", profesor=" + profesor + ", denunciaGrupos=" + denunciaGrupos + ", relUsuarioGrupos="
				+ relUsuarioGrupos + ", relGrupoClases=" + relGrupoClases + "]";
	}

	public Long getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<DenunciaGrupo> getDenunciaGrupos() {
		return denunciaGrupos;
	}

	public void setDenunciaGrupos(List<DenunciaGrupo> denunciaGrupos) {
		this.denunciaGrupos = denunciaGrupos;
	}

	public List<RelTutoradoGrupo> getRelUsuarioGrupos() {
		return relUsuarioGrupos;
	}

	public void setRelUsuarioGrupos(List<RelTutoradoGrupo> relUsuarioGrupos) {
		this.relUsuarioGrupos = relUsuarioGrupos;
	}

	public List<RelGrupoClase> getRelGrupoClases() {
		return relGrupoClases;
	}

	public void setRelGrupoClases(List<RelGrupoClase> relGrupoClases) {
		this.relGrupoClases = relGrupoClases;
	}
	
}
