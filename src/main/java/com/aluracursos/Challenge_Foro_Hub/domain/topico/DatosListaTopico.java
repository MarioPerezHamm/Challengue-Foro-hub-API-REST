package com.aluracursos.Challenge_Foro_Hub.domain.topico;

import com.aluracursos.Challenge_Foro_Hub.domain.curso.Curso;
import com.aluracursos.Challenge_Foro_Hub.domain.usuario.Usuario;

import java.time.LocalDateTime;

// Para listar/mostrar tópicos
public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        Boolean estado,
        String autorNombre
) {
    public DatosListaTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getEstado(),
                topico.getAutor().getNombre()
        );
    }
}
