package com.proyectointegrador.msusuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import com.proyectointegrador.msusuarios.validation.CelularValido;
import com.proyectointegrador.msusuarios.validation.DocumentoValido;
import com.proyectointegrador.msusuarios.validation.MayorDeEdad;

import java.time.LocalDate;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String apellido;

    @DocumentoValido
    private String documentoDeIdentidad;

    @CelularValido
    private String celular;

    @MayorDeEdad
    private LocalDate fechaNacimiento;

    @Email
    private String correo;

    private String clave;
    private Rol rol;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}