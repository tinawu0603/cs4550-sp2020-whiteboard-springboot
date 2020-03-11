package com.example.whiteboard.controllers;

import com.example.whiteboard.services.TopicService;
import com.example.whiteboard.models.Topic;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {
    TopicService service = new TopicService();

    @PostMapping("/api/lessons/{lessonId}/topics")
    public Topic createTopic(@PathVariable("lessonId") Integer lessonId, @RequestBody Topic topic) {
        return service.createTopic(lessonId, topic);
    }

    @GetMapping("/api/lessons/{lessonId}/topics")
    public List<Topic> findTopicsForLesson(@PathVariable("lessonId") Integer lessonId) {
        return service.findTopicsForLesson(lessonId);
    }

    @PutMapping("/api/topics/{topicId}")
    public int updateTopic(@PathVariable("topicId") Integer topicId, @RequestBody Topic topic) {
        return service.updateTopic(topicId, topic);
    }

    @DeleteMapping("/api/topics/{topicId}")
    public int deleteTopic(@PathVariable("topicId") Integer topicId) {
        return service.deleteTopic(topicId);
    }

    @GetMapping("/api/topics")
    public List<Topic> findALlTopics() {
        return service.findAllTopics();
    }

    @GetMapping("/api/topics/{topicId}")
    public Topic findTopicById(@PathVariable("topicId") Integer topicId) {
        return service.findTopicById(topicId);
    }

}