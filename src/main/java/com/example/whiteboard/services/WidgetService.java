package com.example.whiteboard.services;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.models.WidgetType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Maintains the list of widgets
public class WidgetService {
    // local copy of widgets
    List<Widget> widgets = new ArrayList<Widget>();

    // Creates new Widget with a unique ID and add to existing widget collection for the given topic
    public Widget createWidget(String topicId, Widget widget) {
        widgets.add(widget);
        return widget;
    }

    // Returns widget collection for the given topic
    public List<Widget> findWidgetsForTopic(String topicId) {
        List<Widget> results = new ArrayList<Widget>();
        for(Widget w: widgets) {
            if(w.getTopicId().equals(topicId)) {
                results.add(w);
            }
        }
        return results;
    }

    // Removes the widget with the given ID
    // Returns 1 if successful, 0 otherwise
    public int deleteWidget(String widgetId) {
        widgets = widgets.stream()
                .filter(w -> !w.getId().equals(widgetId)).collect(Collectors.toList());
        return 1;
    }

    // Updates the widget with the given ID
    // Returns 1 if successful, 0 otherwise
    public int updateWidget(String widgetId, Widget updatedWidget) {
        for(int i = 0; i < widgets.size(); i += 1) {
            if(widgets.get(i).getId().equals(widgetId)) {
                widgets.set(i, updatedWidget);
                return 1;
            }
        }
        return 0;
    }
}
