package com.aluracursos.Challenge_Foro_Hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        @NotNull Long id,
        @NotBlank String titulo,
        String mensaje
) {
}
