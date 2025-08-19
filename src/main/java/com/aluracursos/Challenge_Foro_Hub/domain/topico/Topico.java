package com.aluracursos.Challenge_Foro_Hub.domain.topico;

import com.aluracursos.Challenge_Foro_Hub.domain.curso.Curso;
import com.aluracursos.Challenge_Foro_Hub.domain.respuesta.Respuesta;
import com.aluracursos.Challenge_Foro_Hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Table(name = "topicos")
@Entity(name = "Topico")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaDeCreacion = LocalDateTime.now();
    private Boolean estado;


    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Respuesta> respuestas = new ArrayList<>();


    public Topico(String titulo, String mensaje, Curso curso, Usuario autor) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.curso = curso;
        this.autor = autor;
        this.estado = true; // por defecto activo
    }

    public void actualizar(DatosActualizacionTopico datos) {
        if (datos.titulo() != null && !datos.titulo().isBlank()) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null && !datos.mensaje().isBlank()) {
            this.mensaje = datos.mensaje();
        }
    }



}

