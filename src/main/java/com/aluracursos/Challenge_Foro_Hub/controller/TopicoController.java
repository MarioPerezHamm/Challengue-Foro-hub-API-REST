package com.aluracursos.Challenge_Foro_Hub.controller;

import com.aluracursos.Challenge_Foro_Hub.domain.curso.CursoRepository;
import com.aluracursos.Challenge_Foro_Hub.domain.topico.*;
import com.aluracursos.Challenge_Foro_Hub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<DatosDetalleTopico> registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriBuilder) {
        var curso = cursoRepository.getReferenceById(datos.idCurso());
        var autor = usuarioRepository.getReferenceById(datos.idUsuario());

        var topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                curso,
                autor
        );

        topicoRepository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }


    @GetMapping
    public ResponseEntity<List<DatosListaTopico>> listar() {
        var topicos = topicoRepository.findAll()
                .stream()
                .map(DatosListaTopico::new)
                .toList();
        return ResponseEntity.ok(topicos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detallar(@PathVariable Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosDetalleTopico> actualizar(
            @RequestBody @Valid DatosActualizacionTopico datos) {

        var topico = topicoRepository.getReferenceById(datos.id());
        topico.actualizar(datos);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!topicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }



}



