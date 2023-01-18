package com.gad.java.rares.assignments.object_containers.models;

public class Unemployed extends Person{
    public Unemployed(String name, Address address, int age) {
        super(name, address, age);
    }

    @Override
    public String toString() {
        return "Unemployed: " + super.toString();
    }
}
