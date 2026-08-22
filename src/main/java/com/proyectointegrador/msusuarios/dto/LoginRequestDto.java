package com.proyectointegrador.msusuarios.dto;

public class LoginRequestDto {
    private String correo;
    private String clave;

    public LoginRequestDto() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}