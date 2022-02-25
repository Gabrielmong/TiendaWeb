package com.TiendaWeb.controller;

import com.TiendaWeb.domain.Cliente;
import com.TiendaWeb.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author gabri
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ClienteService clienteService;

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
        
        
        
        var clientesDB = clienteService.getClientes();
        model.addAttribute("clientesDB", clientesDB);
        
        return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{idcliente}")
    public String modificarCliente(Cliente cliente, Model model){
        var respuesta = clienteService.getCliente(cliente);
        model.addAttribute("cliente", respuesta);
        
        return "modificarCliente";
    }
    
    @GetMapping("elimimnarCliente/{idcliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }
}
