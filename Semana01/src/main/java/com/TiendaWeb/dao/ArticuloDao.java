
package com.TiendaWeb.dao;

import com.TiendaWeb.domain.Articulo;
import org.springframework.data.repository.CrudRepository;

public interface ArticuloDao extends CrudRepository<Articulo, Long> {
    
}
