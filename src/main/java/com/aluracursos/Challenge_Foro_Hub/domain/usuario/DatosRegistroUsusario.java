package com.aluracursos.Challenge_Foro_Hub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsusario(
        @NotBlank String nombre,
        @NotBlank @Email String email,
        @NotBlank String contrasena
) {
}
