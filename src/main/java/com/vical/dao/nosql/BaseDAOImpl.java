package com.vical.dao.nosql;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.vical.dao.IBaseDAO;

public class BaseDAOImpl<Entidad, Llave extends Serializable> implements IBaseDAO<Entidad, Llave> {
	
	private static final long serialVersionUID = 5971420933675305655L;

	@Autowired
    private MongoOperations operations;
    protected Class<Entidad> domainClass;
    
    @Override
    public void crear(Entidad entidad) {
    	operations.insert(entidad);
    }
}
