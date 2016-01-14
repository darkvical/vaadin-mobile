package com.vical.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.vical.domain.Persona;


public interface IPersonaService {	
	void crearPersona(Persona persona);
	List<Persona> listarPersonas(Query query);
}
