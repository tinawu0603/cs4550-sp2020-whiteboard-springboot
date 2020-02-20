package com.example.whiteboard.models;

import java.util.Date;

public class Widget {
    private String id = Long.toString(new Date().getTime());
    private String title;
    private WidgetType type = WidgetType.HEADING;
    private String topicId;
    private Integer order; // index of this widget in widget list
    // optional fields for specific widget types
    private int size = 1; // Useful to represent size of widget (heading 2)
    private String text; // Useful for heading text, paragraph text, etc.
    private String src; // Useful for absolute or relative URL for resource
    private Integer width; // Useful for image or youtube width
    private Integer height; // Useful for image or youtube height
    private String value; // arbitrary initial value

    // Constructor
    public Widget(String title, WidgetType type) {
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

    public WidgetType getType() {
        return type;
    }

    public void setType(WidgetType type) {
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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
