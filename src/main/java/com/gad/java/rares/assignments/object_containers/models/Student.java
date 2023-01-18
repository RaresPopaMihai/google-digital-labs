package com.gad.java.rares.assignments.object_containers.models;

public class Student extends Person {

    public Student(String name, Address address, int age) {
        super(name, address, age);
    }

    @Override public String toString() {
        return "Student: " + super.toString();
    }
}
