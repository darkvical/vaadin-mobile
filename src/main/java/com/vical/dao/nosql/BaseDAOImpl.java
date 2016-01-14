package com.vical.dao.nosql;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.vical.dao.IBaseDAO;

public class BaseDAOImpl<Entidad, Llave extends Serializable> implements IBaseDAO<Entidad, Llave> {
	
	private static final long serialVersionUID = 5971420933675305655L;

	@Autowired
    private MongoOperations operations;
    protected Class<Entidad> domainClass;
    
    @SuppressWarnings("unchecked")
	public BaseDAOImpl() {
    	super();
    	this.domainClass = (Class<Entidad>) ((ParameterizedType) getClass()
    										.getGenericSuperclass()).getActualTypeArguments()[0];
	}
    
    @Override
    public void crear(Entidad entidad) {
    	operations.insert(entidad);
    }
    
    @Override
    public void modificar(Entidad entidad) {
    	operations.save(entidad);
    }
    
    @Override
    public void eliminar(Entidad entidad){
    	operations.remove(entidad);
    }
    
    protected List<Entidad> obtenerEntidades(Query query){
        return operations.find(query, domainClass);
    }

	@Override
	public void grabarTodos(List<Entidad> lista) {
        for (Entidad entidad : lista) {
                operations.save(entidad);
        }
	}
	
	@Override
	public void eliminarTodos(List<Entidad> lista) {
        for (Entidad entidad : lista) {
                operations.remove(entidad);
        }
	}
	
	@Override
	public List<Entidad> obtenerTodos() {
        return operations.findAll(domainClass);
	}
	
	@Override
	public long total() {
        return operations.count(new Query(), domainClass);
	}
}