package com.example.whiteboard.controllers;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= "*")
public class WidgetController {
    WidgetService service = new WidgetService();

    @PostMapping("/api/topics/{topicId}/widgets")
    public Widget createWidget(
            @PathVariable("topicId") String topicId,
            @RequestBody Widget widget) {
        return service.createWidget(topicId, widget);
    }

    @GetMapping("/api/topics/{topicId}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("topicId") String topicId) {
        return service.findWidgetsForTopic(topicId);
    }

    @PutMapping("/api/widgets/{widgetId}")
    public int updateWidget(
            @PathVariable("widgetId") String widgetId,
            @RequestBody Widget widget) {
        return service.updateWidget(widgetId, widget);
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public int deleteWidget(
            @PathVariable("widgetId") String widgetId) {
        return service.deleteWidget(widgetId);
    }

    @PostMapping("/api/widgets/up")
    public List<Widget> updateWidgetUp(
            @RequestBody Widget widget) {
        return service.updateWidgetUp(widget);
    }

    @PostMapping("/api/widgets/down")
    public List<Widget> updateWidgetDown(
            @RequestBody Widget widget) {
        return service.updateWidgetDown(widget);
    }

    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello World";
    }
}
