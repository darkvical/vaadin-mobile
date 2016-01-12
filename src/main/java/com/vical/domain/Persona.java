package com.vical.domain;

import java.util.Date;

public class Persona {
	private String codigo;
	public String getCodigo() { return codigo; }
	public void setCodigo(String codigo) { this.codigo = codigo; }
	
	private String nombre;
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	private Date fechaNacimiento;
	public Date getFechaNacimiento() { return fechaNacimiento; }
	public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
	
	private String email;
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
}