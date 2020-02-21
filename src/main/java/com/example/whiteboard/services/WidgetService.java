package com.example.whiteboard.services;

import com.example.whiteboard.models.Widget;

import java.util.*;

// Maintains the list of widgets
public class WidgetService {
    // local copy of widgets
    Map<String, List<Widget>> widgets = new HashMap<>();

    // Creates new Widget with a unique ID and add to existing widget collection for the given topic
    public Widget createWidget(String topicId, Widget widget) {
        widget.setTopicId(topicId);
        if (widgets.containsKey(topicId)) {
            widget.setOrder(widgets.get(topicId).size());
            widgets.get(topicId).add(widget);
        } else {
            List<Widget> widgetList = new ArrayList<>();
            widget.setOrder(0);
            widgetList.add(widget);
            widgets.put(topicId, widgetList);
        }
        return widget;
    }

    // Returns widget collection for the given topic
    public List<Widget> findWidgetsForTopic(String topicId) {
        if (widgets.containsKey(topicId)) {
            for (int i = 0; i < widgets.get(topicId).size(); i += 1) {
                widgets.get(topicId).get(i).setOrder(i);
            }
            return widgets.get(topicId);
        } else {
            return new ArrayList<>();
        }
    }

    // Removes the widget with the given ID
    // Returns 1 if successful, 0 otherwise
    public int deleteWidget(String wid) {
        for (List<Widget> widgetList : widgets.values()) {
            for(int i = 0; i < widgetList.size(); i += 1)  {
                if(widgetList.get(i).getId().equals(wid)) {
                    widgetList.remove(i);
                    return 1;
                }
            }
        }
        return 0;
    }

    // Updates the widget with the given ID
    // Returns 1 if successful, 0 otherwise
    public int updateWidget(String wid, Widget updatedWidget) {
        for (List<Widget> widgetList : widgets.values()) {
            for(int i = 0; i < widgetList.size(); i += 1)  {
                if(widgetList.get(i).getId().equals(wid)) {
                    widgetList.set(i, updatedWidget);
                    return 1;
                }
            }
        }
        return 0;
    }

    // Move the given widget up
    // Return the new list of widgets for this topic
    public List<Widget> updateWidgetUp(Widget widget) {
        String topicId = widget.getTopicId();
        if (!widgets.containsKey(topicId)) {
            return new ArrayList<>();
        }
        int order = widget.getOrder();
        if (order > 0) {
            widgets.get(topicId).get(order).setOrder(order - 1);
            widgets.get(topicId).get(order - 1).setOrder(order);
            Collections.swap(widgets.get(topicId), order, order-1);
        }
        return widgets.get(topicId);
    }

    // Move the given widget down
    // Returns the new list of widgets for this topic
    public List<Widget> updateWidgetDown(Widget widget) {
        String topicId = widget.getTopicId();
        if (!widgets.containsKey(topicId)) {
            return new ArrayList<>();
        }
        int order = widget.getOrder();
        if (order < widgets.get(topicId).size() - 1) {
            widgets.get(topicId).get(order).setOrder(order + 1);
            widgets.get(topicId).get(order + 1).setOrder(order);
            Collections.swap(widgets.get(topicId), order, order+1);
        }
        return widgets.get(topicId);
    }

    public Widget findWidgetById(String wid) {
        for (List<Widget> widgetList : widgets.values()) {
            for(int i = 0; i < widgetList.size(); i += 1)  {
                if(widgetList.get(i).getId().equals(wid)) {
                    return widgetList.get(i);
                }
            }
        }
        return null;
    }

//    public List<Widget> findAllWidgets() {
//        return widgetList;
//    }
}
