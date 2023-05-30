package com.koyotito.project.model;

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
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String correo;
	private String password;	
	private Integer num_denuncias;
	private Integer idTipoUsuario;
	private String instPseudonimo;
	
	@OneToMany(mappedBy = "usuario")
	private List<ControlUsuario> controlUsuario;
	
	@OneToOne
	private Administrador administrador;
	
	@OneToOne
	private Tutor tutor;
	
	@OneToOne
	private Profesor profesor;

	public Usuario() {
		this.num_denuncias = 0;
	}
	public Usuario(Long idUsuario, String nombre, String apellido1, String apellido2, String correo, String password,
			Integer num_denuncias, Integer idTipoUsuario, List<ControlUsuario> controlUsuario, Administrador administrador, Tutor tutor, Profesor profesor,  String instPseudonimo) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.correo = correo;
		this.password = password;
		this.num_denuncias = num_denuncias;
		this.idTipoUsuario = idTipoUsuario;
		this.controlUsuario = controlUsuario;

		this.administrador = administrador;
		this.tutor = tutor;
		this.profesor = profesor;
		this.instPseudonimo = instPseudonimo;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido1 + ", apellido2="
				+ apellido2 + ", correo=" + correo + ", password=" + password + ", num_denuncias=" + num_denuncias
				+ ", idTipoUsuario=" + idTipoUsuario + ", controlUsuario=" + controlUsuario + ", administrador=" + administrador + ", tutor=" + tutor
				+   ", profesor=" + profesor + "instPseudonimo=" + instPseudonimo +"]";
	}
	public Integer getNum_denuncias() {
		return num_denuncias;
	}
	public void setNum_denuncias(Integer num_denuncias) {
		this.num_denuncias = num_denuncias;
	}
	
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido) {
		this.apellido1 = apellido;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public List<ControlUsuario> getControlUsuario() {
		return controlUsuario;
	}
	public void setControlUsuario(List<ControlUsuario> controlUsuario) {
		this.controlUsuario = controlUsuario;
	}
	public String getInstPseudonimo() {
		return instPseudonimo;
	}
	public void setInstPseudonimo(String instPseudonimo) {
		this.instPseudonimo = instPseudonimo;
	}
}
