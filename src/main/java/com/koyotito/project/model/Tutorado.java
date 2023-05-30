package com.koyotito.project.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Tutorado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long idTutorado;
	private String pseudonimo;
	private Integer nivel;
	private Long puntos;
	
	@ManyToOne
	private Tutor tutor;
	
	@OneToMany(mappedBy = "tutorado")
	private List<RelTutoradoGrupo> relUsuarioGrupos;
	
	@OneToMany(mappedBy = "tutorado")
	private List<Visitas> visitas;
	
	@OneToMany(mappedBy = "tutorado")
	private List<Likes> likes;
	
	@OneToMany(mappedBy = "tutorado")
	private List<RelTutoradoInvitacion> rel;
	
	
	public Tutorado() {

	}
	public Tutorado(Long idTutorado, String pseudonimo, Integer nivel, Long puntos, Usuario usuario, Tutor tutor,
			List<RelTutoradoGrupo> relUsuarioGrupos, List<Visitas> visitas, List<Likes> likes) {
		super();
		this.idTutorado = idTutorado;
		this.pseudonimo = pseudonimo;
		this.nivel = nivel;
		this.puntos = puntos;
		this.tutor = tutor;
		this.relUsuarioGrupos = relUsuarioGrupos;
		this.visitas = visitas;
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "Tutorado [idTutorado=" + idTutorado + ", pseudonimo=" + pseudonimo + ", nivel=" + nivel + ", puntos="
				+ puntos + ", tutor=" + tutor + ", relUsuarioGrupos=" + relUsuarioGrupos
				+ ", visitas=" + visitas + ", likes=" + likes + "]";
	}
	public Long getIdTutorado() {
		return idTutorado;
	}
	public void setIdTutorado(Long idTutorado) {
		this.idTutorado = idTutorado;
	}
	public String getPseudonimo() {
		return pseudonimo;
	}
	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public Long getPuntos() {
		return puntos;
	}
	public void setPuntos(Long puntos) {
		this.puntos = puntos;
	}
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public List<RelTutoradoGrupo> getRelUsuarioGrupos() {
		return relUsuarioGrupos;
	}
	public void setRelUsuarioGrupos(List<RelTutoradoGrupo> relUsuarioGrupos) {
		this.relUsuarioGrupos = relUsuarioGrupos;
	}
	public List<Visitas> getVisitas() {
		return visitas;
	}
	public void setVisitas(List<Visitas> visitas) {
		this.visitas = visitas;
	}
	public List<Likes> getLikes() {
		return likes;
	}
	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}		
}
