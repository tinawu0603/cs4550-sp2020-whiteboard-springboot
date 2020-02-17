package com.example.whiteboard.models;

public class Widget {
    private String id;
    private String title;
    private String type = "HEADING";
    private String topicId;
    private int size = 2;

    // Constructor
    public Widget(String id, String title, String type) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    public Widget() {
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
