package com.domain.glidgbreeds.dto;

import ch.qos.logback.core.pattern.color.BoldRedCompositeConverter;
import com.domain.glidgbreeds.breed.Breed;

import java.util.ArrayList;

public class ResponseDogBreed {
    public Message message;
    public String status;

    public ResponseDogBreed() {
    }

    public ResponseDogBreed(Message message, String status) {
        this.message = message;
        this.status = status;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

