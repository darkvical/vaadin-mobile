package com.vical.dao;

import java.io.Serializable;

public interface IBaseDAO <Entidad, Llave extends Serializable> extends Serializable {
	void crear(Entidad entidad);
}
