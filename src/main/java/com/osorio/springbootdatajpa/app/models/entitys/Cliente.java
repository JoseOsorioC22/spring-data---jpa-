package com.osorio.springbootdatajpa.app.models.entitys;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Logger;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotEmpty
  private String nombre;

  @NotEmpty
  private String apellido;

  @Column(name = "fecha_Nacimiento")
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaNacimiento;

  @Column(name = "create_At")
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate createAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public LocalDate getCreateAt() {
    return createAt;
  }

  public void setCreateAt(LocalDate createAt) {
    this.createAt = createAt;
  }

  @PrePersist
  public void prePersist()
  {

    Logger logger = Logger.getLogger(Cliente.class.getName());
    logger.info("Se va a ejecutar el metodo (PrePersist)....");

  }


}
