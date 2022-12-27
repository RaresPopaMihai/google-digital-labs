package com.gad.java.rares.assignments.oop_principles_2.interfaces;

public interface Mobile {
    void addContact(String id, String firstName, String lastName,String phoneNumber);

    void call(String phoneNumber);

    void listContacts();

    void sendMessage(String phoneNumber, String message);

    void listMessages(String phoneNumber);

    void viewHistory();
}
