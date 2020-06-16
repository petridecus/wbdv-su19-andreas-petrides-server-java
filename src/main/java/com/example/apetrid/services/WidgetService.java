package com.example.apetrid.services;

import java.util.ArrayList;
import java.util.List;

import com.example.apetrid.models.WidgetModel;

import org.springframework.stereotype.Service;

@Service
public class WidgetService {
    List<WidgetModel> widgets = new ArrayList<WidgetModel>();
    {
    }

    public List<WidgetModel> findAllWidgets() {
        return widgets;
    }

    public WidgetModel findWidgetById(Integer wid) {
        for (WidgetModel widget: widgets) {
            if (wid.equals(widget.getId())) {
                return widget;
            }
        }

        return null;
    }

    public List<WidgetModel> findWidgetsForTopic(String topicId) {
        List<WidgetModel> forTopic = new ArrayList<WidgetModel>();
        for (WidgetModel w: widgets) {
            if (w.getTopicId().equals(topicId)) {
                forTopic.add(w);
            }
        }

        return forTopic;
    }

    public WidgetModel createWidget(WidgetModel w) {
        w.setId(widgets.size());
        widgets.add(w);
        return w;
    }

    public Integer deleteWidget(Integer wid) {
        List<WidgetModel> newWidgets = new ArrayList<WidgetModel>();
        for (WidgetModel w: widgets) {
            if (!wid.equals(w.getId())) {
                newWidgets.add(w);
            }
        }

        widgets = newWidgets;
        return wid;
    }

    public WidgetModel updateWidget(Integer wid, WidgetModel w) {
        List<WidgetModel> newWidgets = new ArrayList<WidgetModel>();
        for (WidgetModel widget: widgets) {
            if (wid.equals(widget.getId())) {
                newWidgets.add(w);
            } else {
                newWidgets.add(widget);
            }
        }

        widgets = newWidgets;
        return w;
    }
}