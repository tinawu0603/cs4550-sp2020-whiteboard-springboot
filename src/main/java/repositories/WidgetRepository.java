package com.example.whiteboard.repositories;

import com.example.whiteboard.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

    @Query("SELECT widget FROM Widget widget")
    public List<Widget> findAllWidgets();

    @Query("SELECT widget FROM Widget widget WHERE widget.id=:widgetId")
    public Widget findWidgetById(@Param("wid") Integer widgetId);

    @Query("SELECT widget FROM Widget widget WHERE widget.topicId=:topicId")
    public List<Widget> findWidgetsForTopic(@Param("topicId") String topicId);
}