package com.aluracursos.challengeForohub.service;
import com.aluracursos.challengeForohub.dto.TopicDTO;
import com.aluracursos.challengeForohub.exceptions.ResourceNotFoundException;
import com.aluracursos.challengeForohub.modelo.Topic;
import com.aluracursos.challengeForohub.repositorio.TopicsRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    private final TopicsRepositorio topicsRepositorio;

    @Autowired
    public TopicService(TopicsRepositorio topicsRepositorio) {
        this.topicsRepositorio = topicsRepositorio;
    }

    public TopicDTO createTopic(TopicDTO topicDTO) {
        // Verificar duplicación
        Optional<Topic> existente = topicsRepositorio.findByTítuloAndMensaje(topicDTO.getTítulo(), topicDTO.getMensaje());
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Tópico duplicado: ya existe un tópico con el mismo título y mensaje.");
        }

        // Crear nuevo tópico
        Topic topic = new Topic();
        topic.setTítulo(topicDTO.getTítulo());
        topic.setMensaje(topicDTO.getMensaje());
        topic.setAutor(topicDTO.getAutor());
        topic.setCurso(topicDTO.getCurso());
        topic.setStatusTopico(topicDTO.getStatusTopico());
        Topic savedTopic = topicsRepositorio.save(topic);
        return convertToDTO(savedTopic);
    }
    public List<TopicDTO> getAllTopics() {
        List<Topic> topics = topicsRepositorio.findAll();
        return topics.stream()
                .map(this::convertToDTO)
                .toList();
    }
    public Topic getTopicById(Long id) {
        return topicsRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Topic", "id", id));
    }
    public TopicDTO updateTopic(Long id, TopicDTO topicDTO) {
        Topic topic = getTopicById(id);
        topic.setTítulo(topicDTO.getTítulo());
        topic.setMensaje(topicDTO.getMensaje());
        topic.setAutor(topicDTO.getAutor());
        topic.setCurso(topicDTO.getCurso());
        topic.setStatusTopico(topicDTO.getStatusTopico());
        Topic updatedTopic = topicsRepositorio.save(topic);
        return convertToDTO(updatedTopic);
    }
    public void deleteTopic(Long id) {
        Optional<Topic> topic = topicsRepositorio.findById(id);
        if (topic.isPresent()) {
            topicsRepositorio.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Topic", "id", id);
        }
    }
    public List<TopicDTO> getTop10Topics() {
        Pageable pageable = PageRequest.of(0, 10);
        List<Topic> topics = topicsRepositorio.findAllByOrderByFechaCreacionAsc(pageable);
        return topics.stream()
                .map(this::convertToDTO)
                .toList();
    }
    public List<TopicDTO> searchTopicsByCursoAndYear(String curso, int year) {
        List<Topic> topics = topicsRepositorio.findByCursoAndYearOfFechaCreacion(curso, year);
        return topics.stream()
                .map(this::convertToDTO)
                .toList();
    }

    public Page<TopicDTO> getPaginatedTopics(Pageable pageable) {
        Page<Topic> topics = topicsRepositorio.findAll(pageable);
        return topics.map(this::convertToDTO);
    }
    public TopicDTO convertToDTO(Topic topic) {
        return new TopicDTO(topic.getTítulo(), topic.getMensaje(), topic.getAutor(), topic.getCurso(), topic.getStatusTopico());
    }
}