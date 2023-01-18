package com.gad.java.rares.assignments.object_containers.models;

import java.util.Objects;

public enum Country {
    ROMANIA("Romania"),
    BULGARIA("Bulgaria"),
    SERBIA("Serbia"),
    HUNGARY("Hungary"),
    MOLDOVA("Moldova"),
    UKRAINE("Ukraine"),
    GREECE("Greece"),
    TURKEY("Turkey");


    private String name;

    Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
