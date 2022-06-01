package com.osorio.springbootdatajpa.app.services;

import com.osorio.springbootdatajpa.app.models.DAOs.IClienteDAO;
import com.osorio.springbootdatajpa.app.models.entitys.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDAO clienteDAO;


    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
       return (List<Cliente>)  clienteDAO.findAll();
    }

    @Transactional
    @Override
    public void Save(Cliente cliente) {
        clienteDAO.save(cliente);
    }

    @Transactional (readOnly = true)
    @Override
    public Cliente findOne(Long id) {
       return clienteDAO.findById(id).get();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        clienteDAO.deleteById(id);
    }


}
