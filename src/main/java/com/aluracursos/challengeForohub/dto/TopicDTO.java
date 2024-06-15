package com.aluracursos.challengeForohub.dto;
import jakarta.validation.constraints.NotBlank;

public class TopicDTO {
    private String statusTopico;
    @NotBlank
    private String título;

    @NotBlank
    private String mensaje;

    @NotBlank
    private String autor;

    @NotBlank
    private String curso;

    public TopicDTO(String título, String mensaje, String autor, String curso, String statusTopico) {
        this.título = título;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;
        this.statusTopico = statusTopico;
    }

    // Getters y setters
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
    public String getStatusTopico() {
        return statusTopico;
    }

    public void setStatusTopico(String statusTopico) {
        this.statusTopico = statusTopico;
    }
}