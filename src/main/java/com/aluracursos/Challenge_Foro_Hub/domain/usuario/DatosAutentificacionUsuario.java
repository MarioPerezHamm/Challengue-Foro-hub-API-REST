package com.aluracursos.Challenge_Foro_Hub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAutentificacionUsuario(
        @NotBlank String email,
        @NotBlank String contrasena
) {
}
