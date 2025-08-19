package com.aluracursos.Challenge_Foro_Hub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    // buscar por título
    Topico findByTitulo(String titulo);
}
