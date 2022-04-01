package com.TiendaWeb.service;

import com.TiendaWeb.dao.ClienteDao;
import com.TiendaWeb.dao.CreditoDao;
import com.TiendaWeb.domain.Cliente;
import com.TiendaWeb.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private CreditoDao creditoDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);
        
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional (readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    public List<Cliente> findByCorreo(String correo) {
        return clienteDao.findByCorreo(correo);
    }

    @Override
    public Cliente findByNombreAndApellidos(String nombre, String apellidos) {
        return clienteDao.findByNombreAndApellidos(nombre, apellidos);
    }
    
    
    
}
