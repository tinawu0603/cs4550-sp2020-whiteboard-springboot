package com.example.whiteboard.controllers;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= "*")
public class WidgetController {
    WidgetService service = new WidgetService();

    @PostMapping("/topics/{topicId}/widgets")
    public Widget createWidget(
            @PathVariable("topicId") String topicId,
            @RequestBody Widget widget) {
        return service.createWidget(topicId, widget);
    }

    @GetMapping("/topics/{topicId}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("topicId") String topicId) {
        return service.findWidgetsForTopic(topicId);
    }

    @PutMapping("/widgets/{widgetId}")
    public int updateWidget(
            @PathVariable("widgetId") String widgetId,
            @RequestBody Widget widget) {
        return service.updateWidget(widgetId, widget);
    }

    @DeleteMapping("/widgets/{widgetId}")
    public  int deleteWidget(
            @PathVariable("widgetId") String widgetId) {
        return service.deleteWidget(widgetId);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }
}
