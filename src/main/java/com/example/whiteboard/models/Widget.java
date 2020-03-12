package com.example.whiteboard.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
@Table(name = "widgets")
public class Widget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private WidgetType type = WidgetType.HEADING;

    @JsonIgnore
    @ManyToOne
    private Topic topic;

    private Integer widgetOrder;
    private Integer size;
    private String text;
    private String src;
    private Integer width;
    private Integer height;
    private String value;

    // Constructor
    public Widget(String title, WidgetType type) {
        this.title = title;
        this.type = type;
    }

    public Widget() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getwidgetOrder() {
        return widgetOrder;
    }

    public void setwidgetOrder(Integer widgetOrder) {
        this.widgetOrder = widgetOrder;
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
