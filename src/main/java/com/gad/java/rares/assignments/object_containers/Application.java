package com.gad.java.rares.assignments.object_containers;

import com.gad.java.rares.assignments.object_containers.comparators.PersonAgeComparator;
import com.gad.java.rares.assignments.object_containers.comparators.PersonNameComparator;
import com.gad.java.rares.assignments.object_containers.models.*;

import java.util.*;

public class Application {

    static List<List<Hobby>> hobbiesList;

    public static void main(String[] args) {
        Set<Person> persons = initializeSet(new PersonAgeComparator());
        // Printing with age comparator
        persons.forEach(System.out::println);
        System.out.println("\n-----------------------------------------------\n");
        // Printing with Name Comparator
        persons = initializeSet(new PersonNameComparator());
        persons.forEach(System.out::println);

        //Hobbies
        hobbiesList = setHobbies();
        Map<Person, List<Hobby>> hobbyMap = initializeHobbyMap(persons);
        hobbyMap.forEach((person,hobbies) -> {
            System.out.println("\nThe Person "+person);
            System.out.println("Has the following hobbies: ");
            hobbies.forEach(System.out::println);
        });

    }

    private static List<List<Hobby>> setHobbies() {
        List<List<Hobby>> hobbiesList = new ArrayList<>();

        hobbiesList.add(List.of(new Hobby("Football", 5, List.of(new Address("Sofia", "Serghei", 5, Country.BULGARIA),
                                                                 new Address("Ruse", "Giurgiu", 10, Country.BULGARIA)))));

        hobbiesList.add(List.of(new Hobby("Gym",3, List.of(new Address("Belgrad","Pover",99,Country.SERBIA))),
                                new Hobby("Dancing",2, List.of(new Address("Belgrad","Pover",99,Country.SERBIA),
                                                               new Address("Belgrad","Mav",11,Country.SERBIA)))));

        hobbiesList.add(List.of(new Hobby("Gym",2, List.of(new Address("Tiraspol","Dristor",20,Country.MOLDOVA))),
                                new Hobby("Singing",6, List.of(new Address("Tiraspol","Matei",15,Country.MOLDOVA),
                                                               new Address("Tiraspol","Principala",2,Country.MOLDOVA),
                                                               new Address("Chisinau","Basarab",25,Country.MOLDOVA))),
                                new Hobby("Reading",4, List.of(new Address("Tiraspol","Strad",9,Country.MOLDOVA)))));

        hobbiesList.add(List.of(new Hobby("Gym",3, List.of(new Address("Tiraspol","Dristor",20,Country.MOLDOVA))),
                                new Hobby("Singing",6, List.of(new Address("Tiraspol","Matei",15,Country.MOLDOVA),
                                                               new Address("Tiraspol","Principala",2,Country.MOLDOVA),
                                                               new Address("Chisinau","Basarab",25,Country.MOLDOVA))),
                                new Hobby("Reading",4, List.of(new Address("Tiraspol","Strad",10,Country.MOLDOVA))),
                                new Hobby("Football", 5, List.of(new Address("Tiraspol", "Sportului", 27, Country.MOLDOVA)))));

        hobbiesList.add(List.of(new Hobby("Cooking",7, List.of(new Address("Ankara","Tamam",7,Country.TURKEY)))));

        hobbiesList.add(List.of(new Hobby("Football", 5, List.of(new Address("Sf Gheorghe", "Stadionului", 32, Country.ROMANIA))),
                                new Hobby("Running", 5, List.of(new Address("Sf Gheorghe", "Stadionului", 32, Country.ROMANIA),
                                                                new Address("Bucharest","Baba Novac",22,Country.ROMANIA)))));

        hobbiesList.add(List.of(new Hobby("Football", 2, List.of(new Address("Bucharest", "Ghencea", 20, Country.ROMANIA),
                                                                 new Address("Bucharest", "Stefan Cel Mare", 15, Country.ROMANIA))),
                                new Hobby("Airsoft", 1, List.of(new Address("Bragadiru", "Centurii", 1, Country.ROMANIA),
                                                                new Address("Peris", "Silozului", 1, Country.ROMANIA))),
                                new Hobby("Tinkering", 1, List.of(new Address("Bucharest", "Nordului", 22, Country.ROMANIA)))));


        return hobbiesList;
    }

    private static Map<Person, List<Hobby>> initializeHobbyMap(Set<Person> persons) {
        Map<Person, List<Hobby>> hobbyMap = new HashMap<>();
        int index = 0;
        for (Person person : persons) {
            hobbyMap.put(person, hobbiesList.get(index++));
        }
        return hobbyMap;
    }

    ;

    private static Set<Person> initializeSet(Comparator<Person> comparator) {
        Set<Person> persons = new TreeSet<>(comparator);
        Person person = new Student("Hristov Stoichkov", new Address("Sofia", "Dimitri Rascalov", 1, Country.BULGARIA), 70);
        persons.add(person);
        person = new Employed("Petar Bojic", new Address("Belgrad", "Beolograd", 14, Country.SERBIA), 25);
        persons.add(person);
        person = new Unemployed("Zdob", new Address("Tiraspol", "Basarab", 2, Country.MOLDOVA), 41);
        persons.add(person);
        person = new Unemployed("Zdub", new Address("Chisinau", "Neagoe", 1, Country.MOLDOVA), 42);
        persons.add(person);
        person = new Student("Ahmed Mohamend", new Address("Ankara", "Tamam", 7, Country.TURKEY), 41);
        persons.add(person);
        person = new Student("Cosmin Matei", new Address("Sf. Gheorghe", "Sepsi", 10, Country.ROMANIA), 33);
        persons.add(person);
        person = new Employed("Iosif Rotariu", new Address("Bucharest", "Ghencea", 7, Country.ROMANIA), 68);
        persons.add(person);
        person = new Employed("Iosif Rotariu", new Address("Bucharest", "Ghencea", 7, Country.ROMANIA), 71);
        persons.add(person);
        return persons;
    }
}
