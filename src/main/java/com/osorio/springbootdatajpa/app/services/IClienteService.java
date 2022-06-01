package com.osorio.springbootdatajpa.app.services;

import com.osorio.springbootdatajpa.app.models.DAOs.IClienteDAO;
import com.osorio.springbootdatajpa.app.models.entitys.Cliente;

import java.util.List;

public interface  IClienteService {

    public List<Cliente> findAll();
    public void Save(Cliente cliente);
    public Cliente findOne(Long id );
    public void delete(Long id);

}
