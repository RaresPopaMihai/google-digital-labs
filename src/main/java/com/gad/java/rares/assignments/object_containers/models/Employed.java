package com.gad.java.rares.assignments.object_containers.models;

public class Employed extends Person {
    public Employed(String name, Address address,int age) {
        super(name,address, age);
    }

    @Override
    public String toString() {
        return "Employed: " + super.toString();
    }
}
