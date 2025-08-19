package com.aluracursos.Challenge_Foro_Hub.domain.topico;
// Para registrar un tópico
public record DatosRegistroTopico(
        String titulo,
        String mensaje,
        Long idCurso,
        Long idUsuario
) {
}
