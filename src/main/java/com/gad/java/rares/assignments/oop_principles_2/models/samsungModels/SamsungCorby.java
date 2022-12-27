package com.gad.java.rares.assignments.oop_principles_2.models.samsungModels;

import com.gad.java.rares.assignments.oop_principles_2.models.Material;
import com.gad.java.rares.assignments.oop_principles_2.models.Samsung;

import java.awt.*;

public class SamsungCorby extends Samsung {

    public SamsungCorby(String imei, Color color, Material material) {
        super(imei, color, material);
        this.batteryLife -=60;
    }

    @Override public void addContact(String id, String firstName, String lastName, String phoneNumber) {
        super.addContact(id, firstName, lastName, phoneNumber);
        System.out.println("Model: Corby\n");
    }

    @Override public void listContacts() {
        super.listContacts();
        System.out.println("Model: Corby\n");
    }

    @Override public void viewHistory() {
        super.viewHistory();
        System.out.println("Model: Corby\n");
    }

    @Override public void call(String phoneNumber) {
        super.call(phoneNumber);
        System.out.println("Model: Corby\n");
    }

    @Override public void sendMessage(String phoneNumber, String message) {
        super.sendMessage(phoneNumber, message);
        System.out.println("Model: Corby\n");
    }

    @Override public void listMessages(String phoneNumber) {
        super.listMessages(phoneNumber);
        System.out.println("Model: Corby\n");
    }
}
