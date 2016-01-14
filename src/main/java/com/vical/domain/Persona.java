package com.vical.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Persona {
	private String codigo;
	public String getCodigo() { return codigo; }
	public void setCodigo(String codigo) { this.codigo = codigo; }
	
	private String nombre;
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	private String paterno;
	public String getPaterno() { return paterno; }
	public void setPaterno(String paterno) { this.paterno = paterno; }
	
	private String materno;
	public String getMaterno() { return materno; }
	public void setMaterno(String materno) { this.materno = materno; }
	
	private Date fechaNacimiento;
	public Date getFechaNacimiento() { return fechaNacimiento; }
	public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
	
	private String email;
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	private String telefono;
	public String getTelefono() { return telefono; }
	public void setTelefono(String telefono) { this.telefono = telefono; }		
}