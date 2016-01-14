package com.vical.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDAO <Entidad, Llave extends Serializable> extends Serializable {
	
	void crear(Entidad entidad);
	void modificar(Entidad entidad);
	void eliminar(Entidad entidad);
	void grabarTodos(List<Entidad> lista);
	void eliminarTodos(List<Entidad> lista);
	List<Entidad> obtenerTodos();
	long total();
}