package com.vical.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.vical.domain.Persona;

public interface IPersonaDAO extends IBaseDAO<Persona, String>{
	
	List<Persona> obtenerEntidades(Query query);
}
