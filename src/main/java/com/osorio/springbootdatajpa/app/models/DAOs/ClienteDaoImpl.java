package com.osorio.springbootdatajpa.app.models.DAOs;

import com.osorio.springbootdatajpa.app.models.entitys.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository("ClienteDaoJPA")
public class ClienteDaoImpl implements IClienteDAO{

  @PersistenceContext
  private EntityManager em;


  @Transactional (readOnly = true)
  @Override
  public List<Cliente> findAll() {
    return (List<Cliente>) em.createQuery("from Cliente").getResultList();
  }

  @Override
  @Transactional
  public void Save(Cliente cliente) {
    em.persist(cliente);
  }


}
