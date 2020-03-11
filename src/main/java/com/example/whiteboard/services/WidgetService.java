package com.example.whiteboard.services;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.repositories.TopicRepository;
import com.example.whiteboard.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

// Maintains the list of widgets
@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepo;

    @Autowired
    TopicRepository topicRepo;

    // Creates new Widget with a unique ID and add to existing widget collection for
    // the given topic
    public Widget createWidget(Integer topicId, Widget widget) {
        widget.setTopic(topicRepo.findTopicById(topicId));
        List<Widget> widgetList = this.findWidgetsForTopic(topicId);
        if (widgetList.size() <= 0) {
            widget.setOrder(0);
        } else {
            widget.setOrder(widgetList.size());
        }
        return widgetRepo.save(widget);
    }

    // Returns all widgets
    public List<Widget> findAllWidgets() {
        return widgetRepo.findAllWidgets();
    }

    // Returns widget collection for the given topic
    public List<Widget> findWidgetsForTopic(Integer topicId) {
        return widgetRepo.findWidgetsForTopic(topicId);
    }

    // Removes the widget with the given ID
    // Returns 1 if successful, 0 otherwise
    public int deleteWidget(Integer wid) {
        widgetRepo.deleteById(wid);
        return 1;
    }

    // Updates the widget with the given ID
    // Returns 1 if successful, 0 otherwise
    public int updateWidget(Integer wid, Widget updatedWidget) {
        widgetRepo.updateWidget(updatedWidget, wid);
        return 1;
    }

    // Move the given widget up
    // Return the new list of widgets for this topic
    public List<Widget> updateWidgetUp(Widget widget) {
        int topicId = widget.getTopic().getId();
        int order = widget.getOrder();
        List<Widget> widgetList = widgetRepo.findWidgetsForTopic(topicId);
        // if there are widgets in this topic and the widget is not the highest
        if (widgetList.size() > 0 && order > 0) {
            for (int i = 0; i <= widgetList.size(); i += 1) {
                if (i == order - 1) {
                    Widget thisWidget = widgetList.get(order - 1);
                    widgetRepo.updateWidgetOrder(thisWidget.getId(), order);
                    widgetRepo.updateWidgetOrder(widget.getId(), order - 1);
                }
            }
        }
        return widgetRepo.findWidgetsForTopic(topicId);
    }

    // Move the given widget down
    // Returns the new list of widgets for this topic
    public List<Widget> updateWidgetDown(Widget widget) {
        int topicId = widget.getTopic().getId();
        int order = widget.getOrder();
        List<Widget> widgetList = widgetRepo.findWidgetsForTopic(topicId);
        // if there are widgets in this topic and the widget is not the lowest
        if (widgetList.size() > 0 && order < widgetList.size() - 1) {
            for (int i = 0; i <= widgetList.size(); i += 1) {
                if (i == order) {
                    Widget thatWidget = widgetList.get(order + 1);
                    widgetRepo.updateWidgetOrder(thatWidget.getId(), order);
                    widgetRepo.updateWidgetOrder(widget.getId(), order + 1);
                }
            }
        }
        return widgetRepo.findWidgetsForTopic(topicId);
    }

    public Widget findWidgetById(int wid) {
        return widgetRepo.findWidgetById(wid);
    }
}
