package com.example.whiteboard.services;

import com.example.whiteboard.models.Topic;
import com.example.whiteboard.repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepo;

    // Creates new Topic with a unique ID and add to existing topics collection
    public Topic createTopic(String lessonId, Topic topic) {
        topic.setLessonId(lessonId);
        return topicRepo.save(topic);
    }

    // Returns topic collection for the given lesson
    public List<Topic> findTopicsForLesson(String lessonId) {
        return topicRepo.findTopicsForLesson(lessonId);
    }

    // Removes the topic with the given ID
    // Returns 1 if successful, 0 otherwise
    public int deleteTopic(Integer topicId) {
        topicRepo.deleteById(topicId);
        return 1;
    }

    // Update the topic with the given ID
    // Returns 1 if successful, 0 otherwise
    public int updateTopic(Integer topicId, Topic updatedTopic) {
        topicRepo.updateTopic(updatedTopic, topicId);
        return 1;
    }

    // Returns all the topics
    public List<Topic> findAllTopics() {
        return topicRepo.findAllTopics();
    }

    // Finds the topic given the topic ID
    public Topic findTopicById(Integer topicId) {
        return topicRepo.findTopicById(topicId);
    }
}
