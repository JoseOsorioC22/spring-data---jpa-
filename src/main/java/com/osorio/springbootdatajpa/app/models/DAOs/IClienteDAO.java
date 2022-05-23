package com.osorio.springbootdatajpa.app.models.DAOs;

import com.osorio.springbootdatajpa.app.models.entitys.Cliente;

import java.util.List;

public interface IClienteDAO {

  public List<Cliente> findAll();
  public void Save(Cliente cliente);

}
