package com.koyotito.project.model;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Clase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer idClase;
	private String nombreClase;
	private Date fecha;
	private String estado; // finalizado o en proceso
	private Integer numMeGusta;
	private Integer numTarjetas;
	private Integer numVisitas;
	private Integer numDenuncias;
	private boolean isPapelera;
	
	@ManyToOne
	private Profesor profesor;
	
	@OneToMany(mappedBy = "clase")
	private List<Visitas> visitas;

	@OneToMany(mappedBy = "clase")
	private List<Likes> likes;

	@OneToMany(mappedBy = "clase")
	private List<DenunciaClase> denuncias;
	
	@OneToMany(mappedBy = "clase")
	private List<RelClaseTag> relClaseTags;
	
	@OneToMany(mappedBy = "clase")
	private List<Tarjeta> tarjetas;
		
	@OneToMany(mappedBy = "clase")
	private List<RelGrupoClase> relGrupoClases;

	@OneToMany(mappedBy = "clase")
	private List<RelTarjetaArchivo> relTarjetaArchivos;
	
	public Clase() {

	}
 	
	@Override
	public String toString() {
		return "Clase [idClase=" + idClase + ", nombreClase=" + nombreClase + ", fecha=" + fecha + ", estado=" + estado
				+ ", numMeGusta=" + numMeGusta + ", numTarjetas=" + numTarjetas + ", numVisitas=" + numVisitas
				+ ", numDenuncias=" + numDenuncias + ", isPapelera=" + isPapelera + ", profesor=" + profesor
				+ ", visitas=" + visitas + ", likes=" + likes + ", denuncias=" + denuncias + ", relClaseTags="
				+ relClaseTags + ", tarjetas=" + tarjetas + ", relGrupoClases=" + relGrupoClases
				+ ", relTarjetaArchivos=" + relTarjetaArchivos + "]";
	}
	public Clase(Integer idClase, String nombreClase, Date fecha, String estado, Integer numMeGusta,
			Integer numTarjetas, Integer numVisitas, Integer numDenuncias, boolean isPapelera, Profesor profesor,
			List<Visitas> visitas, List<Likes> likes, List<DenunciaClase> denuncias, List<RelClaseTag> relClaseTags,
			List<Tarjeta> tarjetas, List<RelGrupoClase> relGrupoClases, List<RelTarjetaArchivo> relTarjetaArchivos) {
		super();
		this.idClase = idClase;
		this.nombreClase = nombreClase;
		this.fecha = fecha;
		this.estado = estado;
		this.numMeGusta = numMeGusta;
		this.numTarjetas = numTarjetas;
		this.numVisitas = numVisitas;
		this.numDenuncias = numDenuncias;
		this.isPapelera = isPapelera;
		this.profesor = profesor;
		this.visitas = visitas;
		this.likes = likes;
		this.denuncias = denuncias;
		this.relClaseTags = relClaseTags;
		this.tarjetas = tarjetas;
		this.relGrupoClases = relGrupoClases;
		this.relTarjetaArchivos = relTarjetaArchivos;
	}
	public Integer getIdClase() {
		return idClase;
	}
	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fechaE) {
		this.fecha = fechaE;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getNumMeGusta() {
		return numMeGusta;
	}
	public void setNumMeGusta(Integer numMeGusta) {
		this.numMeGusta = numMeGusta;
	}
	public Integer getNumTarjetas() {
		return numTarjetas;
	}
	public void setNumTarjetas(Integer numTarjetas) {
		this.numTarjetas = numTarjetas;
	}
	public Integer getNumVisitas() {
		return numVisitas;
	}
	public void setNumVisitas(Integer numVisitas) {
		this.numVisitas = numVisitas;
	}
	public Integer getNumDenuncias() {
		return numDenuncias;
	}
	public void setNumDenuncias(Integer numDenuncias) {
		this.numDenuncias = numDenuncias;
	}
	public boolean getPapelera() {
		return isPapelera;
	}
	public void setPapelera(boolean isPapelera) {
		this.isPapelera = isPapelera;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
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
	public List<DenunciaClase> getDenuncias() {
		return denuncias;
	}
	public void setDenuncias(List<DenunciaClase> denuncias) {
		this.denuncias = denuncias;
	}
	public List<RelClaseTag> getRelClaseTags() {
		return relClaseTags;
	}
	public void setRelClaseTags(List<RelClaseTag> relClaseTags) {
		this.relClaseTags = relClaseTags;
	}
	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}
	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	public List<RelGrupoClase> getRelGrupoClases() {
		return relGrupoClases;
	}
	public void setRelGrupoClases(List<RelGrupoClase> relGrupoClases) {
		this.relGrupoClases = relGrupoClases;
	}
	public List<RelTarjetaArchivo> getRelTarjetaArchivos() {
		return relTarjetaArchivos;
	}
	public void setRelTarjetaArchivos(List<RelTarjetaArchivo> relTarjetaArchivos) {
		this.relTarjetaArchivos = relTarjetaArchivos;
	}
}
