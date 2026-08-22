package com.proyectointegrador.msusuarios.service;

import com.proyectointegrador.msusuarios.model.Usuario;

public interface UsuarioService {

    Usuario guardarUsuario(Usuario usuario);
    Usuario buscarPorId(Long id);
}

