package com.osorio.springbootdatajpa.app.models.DAOs;

import com.osorio.springbootdatajpa.app.models.entitys.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IClienteDAO extends CrudRepository<Cliente, Long> {

}
