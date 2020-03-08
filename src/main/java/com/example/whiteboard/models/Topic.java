package com.example.whiteboard.models;

import java.util.Date;
import java.util.List;

public class Topic {
    private String id = Long.toString(new Date().getTime());
    private String title;
    private String description;
    private List<Widget> widgets;
    private String lessonId;

    // Constructor
    public Topic(String title) {
        this.title = title;
    }

    public Topic() {}

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }
}
