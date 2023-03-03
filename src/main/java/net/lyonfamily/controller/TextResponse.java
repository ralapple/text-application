package net.lyonfamily.controller;


import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.twilio.rest.api.v2010.account.Message;
import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(name = "TextResponse", description = "Results of sending a text message")
@Introspected
@JsonClassDescription
public class TextResponse implements Serializable {

    public TextResponse(Message message) {
        this.numberOfSegments = message.getNumSegments();
        this.sid = message.getSid();
        this.direction = message.getDirection().toString();
        this.status = message.getStatus().toString();
    }

    public String getNumberOfSegments() {
        return numberOfSegments;
    }

    public void setNumberOfSegments(String numberOfSegments) {
        this.numberOfSegments = numberOfSegments;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String numberOfSegments;
    private String direction;
    private String sid;
    private String status;


}
