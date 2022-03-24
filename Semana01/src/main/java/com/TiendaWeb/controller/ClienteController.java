package com.TiendaWeb.controller;

import com.TiendaWeb.domain.Cliente;
import com.TiendaWeb.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);

        return "/cliente/listado";
    }
    
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente){
        return "/cliente/modifica";
    }
    
    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/cliente/modificar/{idcliente}")
    public String modificarCliente(Cliente cliente, Model model){
        var respuesta = clienteService.getCliente(cliente);
        model.addAttribute("cliente", respuesta);
        
        return "/cliente/modifica";
    }
    
    @GetMapping("cliente/eliminar/{idcliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
}