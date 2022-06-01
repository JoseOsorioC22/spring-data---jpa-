package com.osorio.springbootdatajpa.app.controllers;

import com.osorio.springbootdatajpa.app.models.DAOs.IClienteDAO;
import com.osorio.springbootdatajpa.app.models.entitys.Cliente;
import com.osorio.springbootdatajpa.app.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "listado de cliente");
        model.addAttribute("clientes", clienteService.findAll());
        return "listar";
    }

    ;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String Crear(Map<String, Object> model) {
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Creacion de cliente");

        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String Guardar(@Valid Cliente cliente, BindingResult bindingResult, Model model , SessionStatus status) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("titulo", "formulario cliente" );
            return "form";
        }
        clienteService.Save(cliente);

        status.setComplete();
        return "redirect:listar";
    }

    @RequestMapping(value = "form/{id}")
    public String editar(@PathVariable Long id, Map<String, Object> model) {

       Cliente cliente =   clienteService.findOne(id);

     //   Optional<Cliente> opcional = Optional.ofNullable( clienteDAO.findOne(id));

        model.put("cliente", cliente);
        model.put("titulo", "Editar Cliente");
            return "form";
    }

    @RequestMapping(value = "/eliminar/{id}")

    public String Eliminar(@PathVariable Long id)
    {
        if(id > 0 )
        {
            clienteService.delete(id);
        }
        return "redirect:/listar";
    }

}
