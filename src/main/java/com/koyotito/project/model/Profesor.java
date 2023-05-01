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
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer idProfesor;
	private String correoContacto;
	private Integer numFaltasTotales; 
	private String institucion;
	
	@OneToOne(mappedBy = "profesor")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "profesor")
	private List<Likes> likes;
	
	@OneToMany(mappedBy = "profesor")
	private List<Visitas> visitas;
	
	@OneToMany(mappedBy = "profesor")
	private List<Clase> clases;
	
	@OneToMany(mappedBy = "profesor")
	private List<Grupo> grupos;
	
	@OneToMany(mappedBy = "profesor")
	private List<Archivo> archivos;
	
	
	
	public Profesor() {
		
	}

	public Profesor(Integer idProfesor, String correoContacto, Integer numFaltasTotales, Usuario usuario,
			List<Likes> likes, List<Visitas> visitas, List<Clase> clases, List<Grupo> grupos, List<Archivo> archivos) {
		super();
		this.idProfesor = idProfesor;
		this.correoContacto = correoContacto;
		this.numFaltasTotales = numFaltasTotales;
		this.usuario = usuario;
		this.likes = likes;
		this.visitas = visitas;
		this.clases = clases;
		this.grupos = grupos;
		this.archivos = archivos;
	}


	@Override
	public String toString() {
		return "Profesor [idProfesor=" + idProfesor + ", correoContacto=" + correoContacto + ", numFaltasTotales="
				+ numFaltasTotales + ", usuario=" + usuario + ", likes=" + likes + ", visitas=" + visitas + ", clases="
				+ clases + ", grupos=" + grupos + ", archivos=" + archivos + ", institucion=" +  institucion + "]";
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getCorreoContacto() {
		return correoContacto;
	}

	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}

	public Integer getNumFaltasTotales() {
		return numFaltasTotales;
	}

	public void setNumFaltasTotales(Integer numFaltasTotales) {
		this.numFaltasTotales = numFaltasTotales;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Likes> getLikes() {
		return likes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}

	public List<Visitas> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<Visitas> visitas) {
		this.visitas = visitas;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Archivo> getArchivos() {
		return archivos;
	}

	public void setArchivos(List<Archivo> archivos) {
		this.archivos = archivos;
	}
	
	



}
