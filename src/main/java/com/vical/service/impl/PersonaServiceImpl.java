package com.vical.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vical.dao.IPersonaDAO;
import com.vical.domain.Persona;
import com.vical.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaDAO personaDAO;
	
	@Override
	public void crearPersona(Persona persona) {
		personaDAO.crear(persona);
	}
}
