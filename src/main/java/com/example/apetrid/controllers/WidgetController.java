package com.example.apetrid.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import com.example.apetrid.models.WidgetModel;
import com.example.apetrid.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    @Autowired
    WidgetService widgetService;

    @GetMapping("/api/widgets")
    public List<WidgetModel> findAllWidgets() {
        return widgetService.findAllWidgets();
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<WidgetModel> findWidgetsForTopic(@PathVariable("tid") String tid) {
        return widgetService.findWidgetsForTopic(tid);
    }

    @GetMapping("/api/widgets/{wid}")
    public WidgetModel findWidgetById(@PathParam("wid") Integer wid) {
        return widgetService.findWidgetById(wid);
    }

    @PostMapping("/api/topics/{tid}/widgets")
    public WidgetModel createWidget(@PathVariable("tid") String tid,
                                    @RequestBody WidgetModel widget) {
        return widgetService.createWidget(widget);
    }

    @PutMapping("/api/widgets/{wid}")
    public WidgetModel updateWidget(@PathVariable("wid") Integer wid, 
                                        @RequestBody WidgetModel widget) {
        return widgetService.updateWidget(wid, widget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public Integer deleteWidget(@PathParam("wid") Integer wid) {
        return widgetService.deleteWidget(wid);
    }
}