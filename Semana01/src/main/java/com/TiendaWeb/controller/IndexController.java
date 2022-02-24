package com.TiendaWeb.controller;

import com.TiendaWeb.dao.ClienteDao;
import com.TiendaWeb.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author gabri
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ClienteDao clienteDao;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura MVC");

        var mensaje = "Mensaje desde el controlador";
        model.addAttribute("Texto Saludo", mensaje);

        Cliente cliente = new Cliente("Gabriel", "Monge lizano", "gabriel.monge.lizano@gmail.com", "86837078");
        model.addAttribute(cliente);

        Cliente cliente2 = new Cliente("Elam", "Garita", "wolfo@gmail.com", "88858685");
        var clientes = Arrays.asList(cliente, cliente2);
        model.addAttribute("clientes", clientes);
        
        
        
        var clientesDB = clienteDao.findAll();
        model.addAttribute("clientesDB", clientesDB);
        
        return "index";
    }

}
