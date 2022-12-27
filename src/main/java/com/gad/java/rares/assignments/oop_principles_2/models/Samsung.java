package com.gad.java.rares.assignments.oop_principles_2.models;

import java.awt.*;

public abstract class Samsung extends Phone{

    public Samsung( String imei, Color color, Material material) {
        super( imei, color, material);
        //Base batteryLife
        this.batteryLife = 480;
    }

    @Override public void addContact(String id, String firstName, String lastName, String phoneNumber) {
        System.out.println("Adding contact to Samsung");
        super.addContact(id, firstName, lastName, phoneNumber);
    }

    @Override public void listContacts() {
        System.out.println("Listing contacts for Samsung");
        super.listContacts();
    }

    @Override public void viewHistory() {
        System.out.println("Viewing history for Samsung");
        super.viewHistory();
    }

    @Override public void call(String phoneNumber) {
        System.out.println("Performing call on Samsung");
        super.call(phoneNumber);
    }

    @Override public void sendMessage(String phoneNumber, String message) {
        System.out.println("Sending message on Samsung");
        super.sendMessage(phoneNumber, message);
    }

    @Override public void listMessages(String phoneNumber) {
        System.out.println("Listing messages on Samsung");
        super.listMessages(phoneNumber);
    }
}
