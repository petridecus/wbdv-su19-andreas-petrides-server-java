package com.example.apetrid.models;

public class WidgetModel {
    /**
     * name String
     * id Integer 
     * type String
     * widgetOrder Integer
     * text String
     * src, url, and/or href String
     * size Integer
     * width, height Integer
     * cssClass String
     * style String
     * value String
     * topicId String
     */
    private Integer id;
    private String name;
    private String type;
    private Integer widgetOrder;
    private String text;
    private String src;
    private Integer size;
    private String cssClass;
    private Integer width;
    private Integer height;
    private String style;
    private String value;
    private String topicId;
    
    public WidgetModel(Integer id, String name, String type, Integer widgetOrder, 
                        String text, String src, Integer size, String cssClass, 
                        Integer width, Integer height, String style, String value,
                        String topicId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.widgetOrder = widgetOrder;
        this.text = text;
        this.src = src;
        this.size = size;
        this.cssClass = cssClass;
        this.width = width;
        this.height = height;
        this.style = style;
        this.value = value;
        this.topicId = topicId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getWidgetOrder() {
        return this.widgetOrder;
    }

    public void setWidgetOrder(Integer widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSrc() {
        return this.src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getCssClass() {
        return this.cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTopicId() {
        return this.topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }
}