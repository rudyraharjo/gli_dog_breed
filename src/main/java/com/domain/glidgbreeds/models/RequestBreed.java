package com.domain.glidgbreeds.models;

import java.util.ArrayList;

public class RequestBreed {
    public String name;
    public ArrayList<String> sub;

    public RequestBreed(String name, ArrayList<String> sub) {
        this.name = name;
        this.sub = sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getSub() {
        return sub;
    }

    public void setSub(ArrayList<String> sub) {
        this.sub = sub;
    }
}

