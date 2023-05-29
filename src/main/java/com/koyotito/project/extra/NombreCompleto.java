package com.koyotito.project.extra;

public class NombreCompleto {
	private String nombres;
	private String apellido1;
	private String apellido2;
		
	public NombreCompleto(){
		
	}

	public NombreCompleto(String nombres, String apellido1, String apellido2) {
		super();
		this.nombres = nombres;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}
	@Override
	public String toString() {
		return "NombreCompleto [nombres=" + nombres + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + "]";
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	
	
}
