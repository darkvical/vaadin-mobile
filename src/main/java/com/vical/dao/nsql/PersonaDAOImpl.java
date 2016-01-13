package com.vical.dao.nsql;

import org.springframework.stereotype.Repository;

import com.vical.dao.IPersonaDAO;
import com.vical.domain.Persona;

@Repository
public class PersonaDAOImpl extends BaseDAOImpl<Persona, String> implements IPersonaDAO {
	private static final long serialVersionUID = 5211963990736381599L;

//	@Override
//	public void crear(Persona entidad) {
//	}

}
