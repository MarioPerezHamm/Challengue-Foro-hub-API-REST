package com.aluracursos.Challenge_Foro_Hub.domain.topico;

import com.aluracursos.Challenge_Foro_Hub.domain.respuesta.DatosDetalleRespuesta;
import com.aluracursos.Challenge_Foro_Hub.domain.respuesta.DatosListaRespuesta;

import java.time.LocalDateTime;
import java.util.List;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autor,
        String curso,
        List<DatosDetalleRespuesta> respuestas
) {
    public DatosDetalleTopico (Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre(),
                topico.getRespuestas()
                        .stream()
                        .map(DatosDetalleRespuesta::new)
                        .toList()
        );
    }
}
