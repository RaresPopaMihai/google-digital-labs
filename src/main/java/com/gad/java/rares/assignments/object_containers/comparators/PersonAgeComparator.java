package com.gad.java.rares.assignments.object_containers.comparators;

import com.gad.java.rares.assignments.object_containers.models.Person;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {

    @Override public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }

}
