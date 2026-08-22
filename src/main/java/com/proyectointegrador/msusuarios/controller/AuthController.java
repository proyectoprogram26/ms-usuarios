package com.proyectointegrador.msusuarios.controller;

import com.proyectointegrador.msusuarios.dto.LoginRequestDto;
import com.proyectointegrador.msusuarios.dto.LoginResponseDto;
import com.proyectointegrador.msusuarios.model.Usuario;
import com.proyectointegrador.msusuarios.repository.UsuarioRepository;
import com.proyectointegrador.msusuarios.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(UsuarioRepository usuarioRepository,
                          PasswordEncoder passwordEncoder,
                          JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest) {
        Usuario usuario = usuarioRepository.findByCorreo(loginRequest.getCorreo())
                .orElse(null);

        if (usuario == null || !passwordEncoder.matches(loginRequest.getClave(), usuario.getClave())) {
            return ResponseEntity.status(401).body("Correo o clave incorrectos");
        }

        String token = jwtService.generarToken(usuario.getCorreo(), usuario.getRol().name());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }
}