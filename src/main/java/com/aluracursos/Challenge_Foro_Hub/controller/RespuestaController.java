package com.aluracursos.Challenge_Foro_Hub.controller;

import com.aluracursos.Challenge_Foro_Hub.domain.respuesta.DatosDetalleRespuesta;
import com.aluracursos.Challenge_Foro_Hub.domain.respuesta.DatosRegistroRespuesta;
import com.aluracursos.Challenge_Foro_Hub.domain.respuesta.Respuesta;
import com.aluracursos.Challenge_Foro_Hub.domain.respuesta.RespuestaRepository;
import com.aluracursos.Challenge_Foro_Hub.domain.topico.TopicoRepository;
import com.aluracursos.Challenge_Foro_Hub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<DatosDetalleRespuesta> registrar(@RequestBody @Valid DatosRegistroRespuesta datos, UriComponentsBuilder uriBuilder) {
        var autor = usuarioRepository.getReferenceById(datos.idUsuario());
        var topico = topicoRepository.getReferenceById(datos.idTopico());

        var respuesta = new Respuesta(
                datos.mensaje(),
                topico,
                autor
        );

        respuestaRepository.save(respuesta);

        var uri = uriBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleRespuesta(respuesta));
    }

    @GetMapping
    public ResponseEntity<List<DatosDetalleRespuesta>> listar() {
        List<DatosDetalleRespuesta> respuestas = respuestaRepository.findAll()
                .stream()
                .map(DatosDetalleRespuesta::new)
                .toList();
        return ResponseEntity.ok(respuestas);
    }
}


