package com.aluracursos.Challenge_Foro_Hub.controller;

import com.aluracursos.Challenge_Foro_Hub.domain.usuario.DatosDetalleUsuario;
import com.aluracursos.Challenge_Foro_Hub.domain.usuario.Usuario;
import com.aluracursos.Challenge_Foro_Hub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity<Usuario> registrar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriBuilder) {
        var usuarioGuardado = repository.save(usuario);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuarioGuardado.getId()).toUri();
        return ResponseEntity.created(uri).body(usuarioGuardado);
    }


    @GetMapping
    public ResponseEntity<List<DatosDetalleUsuario>> listar() {
        List<DatosDetalleUsuario> usuariosDTO = repository.findAll()
                .stream()
                .map(u -> new DatosDetalleUsuario(u.getId(), u.getNombre(), u.getEmail()))
                .toList();
        return ResponseEntity.ok(usuariosDTO);
    }

}

