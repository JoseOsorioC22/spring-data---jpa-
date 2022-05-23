package com.osorio.springbootdatajpa.app.controllers;

import com.osorio.springbootdatajpa.app.models.DAOs.IClienteDAO;
import com.osorio.springbootdatajpa.app.models.entitys.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Controller
public class ClienteController {

  @Autowired
  @Qualifier("ClienteDaoJPA")
  private IClienteDAO clienteDAO;

  @RequestMapping(value = "/listar", method = RequestMethod.GET )
  public String listar(Model model)
  {
    model.addAttribute("titulo", "listado de cliente");
    model.addAttribute("clientes", clienteDAO.findAll());
    return "listar";
  };

  @RequestMapping(value = "/form", method = RequestMethod.GET)
  public String Crear(Map<String,Object> model)
  {
    Cliente cliente = new Cliente();
    model.put("cliente", cliente);
    model.put("titulo", "Creacion de cliente");

      return "form";
  }

@RequestMapping(value = "/form", method = RequestMethod.POST)
public String Guardar(@Valid  Cliente cliente, BindingResult bindingResult, Model model )
{
 if(bindingResult.hasErrors())
 {
   model.addAttribute("titulo", "formulario cliente");
   return "form";
 }
    clienteDAO.Save(cliente);

    return "redirect:listar";
}

}
