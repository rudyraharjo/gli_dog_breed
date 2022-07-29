package com.domain.glidgbreeds.dto;

import com.domain.glidgbreeds.subbreed.SubBreed;

import java.util.ArrayList;

public class RequestBreed {
    public String name;
    public ArrayList<SubBreed> subBreeds;

    public RequestBreed() {
    }

    public RequestBreed(String name, ArrayList<SubBreed> subBreeds) {
        this.name = name;
        this.subBreeds = subBreeds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<SubBreed> getSubBreeds() {
        return subBreeds;
    }

    public void setSubBreeds(ArrayList<SubBreed> subBreeds) {
        this.subBreeds = subBreeds;
    }
}

