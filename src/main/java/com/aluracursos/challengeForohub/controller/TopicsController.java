package com.aluracursos.challengeForohub.controller;
import com.aluracursos.challengeForohub.dto.TopicDTO;
import com.aluracursos.challengeForohub.modelo.Topic;
import com.aluracursos.challengeForohub.service.TopicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicsController {

    private final TopicService topicService;

    @Autowired
    public TopicsController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDTO> createTopic(@Valid @RequestBody TopicDTO topicDTO) {
        TopicDTO newTopic = topicService.createTopic(topicDTO);
        return ResponseEntity.ok(newTopic);
    }

    @GetMapping
    public ResponseEntity<List<TopicDTO>> getAllTopics() {
        List<TopicDTO> topics = topicService.getAllTopics();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDTO> getTopic(@PathVariable Long id) {
        TopicDTO topic = topicService.convertToDTO(topicService.getTopicById(id));
        return ResponseEntity.ok(topic);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDTO> updateTopic(@PathVariable Long id, @Valid @RequestBody TopicDTO topicDTO) {
        TopicDTO updatedTopic = topicService.updateTopic(id, topicDTO);
        return ResponseEntity.ok(updatedTopic);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para los primeros 10 resultados ordenados por fecha de creación en orden ascendente
    @GetMapping("/top10")
    public ResponseEntity<List<TopicDTO>> getTop10Topics() {
        List<TopicDTO> topics = topicService.getTop10Topics();
        return ResponseEntity.ok(topics);
    }

    // Endpoint para búsqueda por nombre de curso y año específico
    @GetMapping("/search")
    public ResponseEntity<List<TopicDTO>> searchTopics(@RequestParam String curso, @RequestParam int year) {
        List<TopicDTO> topics = topicService.searchTopicsByCursoAndYear(curso, year);
        return ResponseEntity.ok(topics);
    }

    // Endpoint para paginación
    @GetMapping("/paginated")
    public ResponseEntity<Page<TopicDTO>> getPaginatedTopics(
            @PageableDefault(sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<TopicDTO> topics = topicService.getPaginatedTopics(pageable);
        return ResponseEntity.ok(topics);
    }

    // Helper methods to convert between Topic and TopicDTO
    private TopicDTO convertToDTO(Topic topic) {
        return new TopicDTO(topic.getTítulo(), topic.getMensaje(), topic.getAutor(), topic.getCurso(), topic.getStatusTopico());
    }

    private Topic convertToEntity(TopicDTO topicDTO) {
        Topic topic = new Topic();
        topic.setTítulo(topicDTO.getTítulo());
        topic.setMensaje(topicDTO.getMensaje());
        topic.setAutor(topicDTO.getAutor());
        topic.setCurso(topicDTO.getCurso());
        return topic;
    }
}