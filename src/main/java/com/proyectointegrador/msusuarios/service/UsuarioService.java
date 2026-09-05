package com.proyectointegrador.msusuarios.service;

import com.proyectointegrador.msusuarios.model.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Usuario guardarUsuario(Usuario usuario);

    Optional<Usuario> buscarPorId(Long id);
}