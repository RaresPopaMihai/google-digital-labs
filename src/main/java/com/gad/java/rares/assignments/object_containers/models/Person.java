package com.gad.java.rares.assignments.object_containers.models;

import java.util.Comparator;
import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private Address address;

    public Person(String name, Address address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(address, person.address);
    }

    @Override public int hashCode() {
        return Objects.hash(name, address);
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }
}
