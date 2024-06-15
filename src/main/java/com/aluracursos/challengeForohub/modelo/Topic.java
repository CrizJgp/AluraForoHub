package com.aluracursos.challengeForohub.modelo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "Tópico")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Column(name = "título")
    private String título;
    @NotBlank
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "fecha_creación")
    private Date fechaCreacion = new Date();
    @NotBlank
    @Column(name = "status_tópico")
    private String statusTopico;
    @NotBlank
    @Column(name = "autor")
    private String autor;
    @NotBlank
    @Column(name = "curso")
    private String curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getStatusTopico() {
        return statusTopico;
    }

    public void setStatusTopico(String statusTopico) {
        this.statusTopico = statusTopico;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}