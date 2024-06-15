package com.aluracursos.challengeForohub.repositorio;
import com.aluracursos.challengeForohub.modelo.Topic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TopicsRepositorio extends JpaRepository<Topic, Long> {
    Optional<Topic> findByTítuloAndMensaje(String titulo, String mensaje);
    List<Topic> findAllByOrderByFechaCreacionAsc(Pageable pageable);
    @Query("SELECT t FROM Topic t WHERE t.curso = :curso AND YEAR(t.fechaCreacion) = :year")
    List<Topic> findByCursoAndYearOfFechaCreacion(@Param("curso") String curso, @Param("year") int year);
}