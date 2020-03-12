package com.example.whiteboard.repositories;

import com.example.whiteboard.models.Topic;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    @Query("SELECT topic FROM Topic topic")
    public List<Topic> findAllTopics();

    @Query("SELECT topic FROM Topic topic WHERE topic.id=:topicId")
    public Topic findTopicById(@Param("topicId") Integer topicId);

    @Query("SELECT topic FROM Topic topic WHERE topic.lessonId=:lessonId")
    public List<Topic> findTopicsForLesson(@Param("lessonId") String lessonId);

    @Modifying
    @Query("UPDATE Topic topic SET topic=:topic WHERE topic.id=:topicId")
    public int updateTopic(@Param("topic") Topic topic, @Param("topicId") Integer topicId);
}