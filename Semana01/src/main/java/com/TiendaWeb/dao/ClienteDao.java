
package com.TiendaWeb.dao;

import com.TiendaWeb.domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
    
    public List<Cliente> findByCorreo(String correo);
    public Cliente findByNombreAndApellidos(String nombre, String apellidos);
}
