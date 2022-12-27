package com.gad.java.rares.assignments.oop_principles_2.models;

import java.awt.*;

public abstract class Apple extends Phone{

    public Apple(String imei, Color color, Material material) {
        super(imei, color, material);
        //Base batteryLife
        this.batteryLife = 360;
    }

    @Override public void addContact(String id, String firstName, String lastName, String phoneNumber) {
        System.out.println("Adding contact to Apple");
        super.addContact(id, firstName, lastName, phoneNumber);
    }

    @Override public void listContacts() {
        System.out.println("Listing contacts for Apple");
        super.listContacts();
    }

    @Override public void viewHistory() {
        System.out.println("Viewing history for Apple");
        super.viewHistory();
    }

    @Override public void call(String phoneNumber) {
        System.out.println("Performing call on Apple");
        super.call(phoneNumber);
    }

    @Override public void sendMessage(String phoneNumber, String message) {
        System.out.println("Sending message on Apple");
        super.sendMessage(phoneNumber, message);
    }

    @Override public void listMessages(String phoneNumber) {
        System.out.println("Listing messages on Apple");
        super.listMessages(phoneNumber);
    }
}
