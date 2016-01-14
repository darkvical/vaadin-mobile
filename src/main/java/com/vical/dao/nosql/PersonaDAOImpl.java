package com.vical.dao.nosql;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.vical.dao.IPersonaDAO;
import com.vical.domain.Persona;

@Repository
public class PersonaDAOImpl extends BaseDAOImpl<Persona, String> implements IPersonaDAO {
	private static final long serialVersionUID = 5211963990736381599L;
	
	@Override
	public List<Persona> obtenerEntidades(Query query) {
		return super.obtenerEntidades(query);
	}
}
