package com.proyectointegrador.msusuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private String documentoDeIdentidad;
    private String celular;
    private LocalDate fechaNacimiento;
    @Email
    private String correo;
    private String clave;
    private Rol rol;
}
