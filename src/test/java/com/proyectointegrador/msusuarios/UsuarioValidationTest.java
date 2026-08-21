package com.proyectointegrador.msusuarios;

import com.proyectointegrador.msusuarios.model.Rol;
import com.proyectointegrador.msusuarios.model.Usuario;
import com.proyectointegrador.msusuarios.repository.UsuarioRepository;
import com.proyectointegrador.msusuarios.service.UsuarioServiceImpl;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Field;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioValidationTest {

    private final Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void debeFallarCuandoElEmailEsInvalido() throws Exception {
        Usuario usuario = new Usuario();

        ponerValor(usuario, "correo", "correo-invalido");

        assertFalse(validator.validate(usuario).isEmpty());
    }

    @Test
    void debeFallarCuandoElCelularEsMuyLargo() throws Exception {
        Usuario usuario = new Usuario();

        ponerValor(usuario, "celular", "12345678901234");

        assertFalse(validator.validate(usuario).isEmpty());
    }

    @Test
    void debeFallarCuandoElDocumentoTieneLetras() throws Exception {
        Usuario usuario = new Usuario();

        ponerValor(usuario, "documentoDeIdentidad", "12345ABC");

        assertFalse(validator.validate(usuario).isEmpty());
    }

    @Test
    void debeFallarCuandoEsMenorDeEdad() throws Exception {
        Usuario usuario = new Usuario();

        ponerValor(usuario, "fechaNacimiento", LocalDate.now().minusYears(17));

        assertFalse(validator.validate(usuario).isEmpty());
    }

    @Test
    void debeCrearUsuarioExitosamente() {
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);

        Usuario usuario = new Usuario();
        usuario.setClave("123456");

        when(passwordEncoder.encode("123456")).thenReturn("clave-encriptada");
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        UsuarioServiceImpl usuarioService =
                new UsuarioServiceImpl(usuarioRepository, passwordEncoder);

        Usuario resultado = usuarioService.guardarUsuario(usuario);

        assertEquals("clave-encriptada", resultado.getClave());
        assertEquals(Rol.PROPIETARIO, resultado.getRol());

        verify(usuarioRepository).save(usuario);
    }

    private void ponerValor(Usuario usuario, String nombreCampo, Object valor)
            throws Exception {

        Field campo = Usuario.class.getDeclaredField(nombreCampo);
        campo.setAccessible(true);
        campo.set(usuario, valor);
    }
}
