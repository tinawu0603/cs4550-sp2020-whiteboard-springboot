package com.example.whiteboard.repositories;

import com.example.whiteboard.models.Widget;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

    @Query("SELECT widget FROM Widget widget")
    public List<Widget> findAllWidgets();

    @Query("SELECT widget FROM Widget widget WHERE widget.id=:widgetId ORDER BY widget.widgetOrder")
    public Widget findWidgetById(@Param("widgetId") Integer widgetId);

    @Query("SELECT widget FROM Widget widget WHERE widget.topic.id=:topicId")
    public List<Widget> findWidgetsForTopic(@Param("topicId") Integer topicId);

    @Modifying
    @Query("UPDATE Widget widget SET widget.widgetOrder=:order WHERE widget.id=:widgetId")
    public int updateWidgetOrder(@Param("widgetId") Integer widgetId, @Param("order") Integer order);

    @Modifying
    @Query("UPDATE Widget widget SET widget=:widget WHERE widget.id=:widgetId")
    public int updateWidget(@Param("widget") Widget widget, @Param("widgetId") Integer widgetId);
}