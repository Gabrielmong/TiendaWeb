
package com.TiendaWeb.dao;

import com.TiendaWeb.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
    
}
