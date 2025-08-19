package com.aluracursos.Challenge_Foro_Hub.controller;

import com.aluracursos.Challenge_Foro_Hub.domain.curso.Curso;
import com.aluracursos.Challenge_Foro_Hub.domain.curso.CursoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity<Curso> registrar(@RequestBody @Valid Curso curso, UriComponentsBuilder uriBuilder) {
        var cursoGuardado = repository.save(curso);
        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(cursoGuardado.getId()).toUri();
        return ResponseEntity.created(uri).body(cursoGuardado);
    }

    @GetMapping
    public List<Curso> listar() {
        return repository.findAll();
    }
}

