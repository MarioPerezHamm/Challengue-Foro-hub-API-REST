package com.aluracursos.Challenge_Foro_Hub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosDetalleRespuesta(
        Long id,
        String mensaje,
        String autor,
        LocalDateTime fechaCreacion

) {
    public DatosDetalleRespuesta(Respuesta respuesta){
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getAutor().getNombre(),
                respuesta.getFechaCreacion()

        );
    }
}
