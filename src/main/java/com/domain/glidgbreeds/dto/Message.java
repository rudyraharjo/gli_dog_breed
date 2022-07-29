package com.domain.glidgbreeds.dto;

import com.domain.glidgbreeds.breed.Breed;

import java.util.ArrayList;

public class Message {
    public ArrayList<String> name;

    public Message() {
    }

    public Message(ArrayList<String> name) {
        this.name = name;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }
}
