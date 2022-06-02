package com.poc.insurance.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.poc.insurance.converters.MapToStringConverter;

import javax.persistence.*;
import java.util.Map;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvent;
    private String id;
    private String specVersion;
    private String source;
    private String type;
    private String time;
    private String subject;
    private String correlationID;
    private String dataContentType;
    //@Column(columnDefinition = "TEXT")
    //@Convert(converter = JSONOjectConverter.class)
    //private JSONObject data;
    @Column(name = "mapvalue")
    @Convert(converter = MapToStringConverter.class)
    private Map<String, Object> data;

    public Integer getIdEvent() {
        return idEvent;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecVersion() {
        return specVersion;
    }

    public void setSpecVersion(String specVersion) {
        this.specVersion = specVersion;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCorrelationID() {
        return correlationID;
    }

    public void setCorrelationID(String correlationID) {
        this.correlationID = correlationID;
    }

    public String getDataContentType() {
        return dataContentType;
    }

    public void setDataContentType(String dataContentType) {
        this.dataContentType = dataContentType;
    }


}
