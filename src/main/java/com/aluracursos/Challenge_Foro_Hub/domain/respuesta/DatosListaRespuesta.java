package com.aluracursos.Challenge_Foro_Hub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosListaRespuesta(
        Long id,
        String mensaje,
        String autorNombre,
        LocalDateTime fechaCreacion
) {
    public DatosListaRespuesta(Respuesta respuesta){
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getAutor().getNombre(),
                respuesta.getFechaCreacion()
        );
    }
}
