package com.gad.java.rares.assignments.oop_principles_2.models;

import com.gad.java.rares.assignments.oop_principles_2.interfaces.Mobile;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Phone implements Mobile {

    private List<Contact> contacts;

    private Map<String, List<String>> messages;

    private List<String> history;

    protected int batteryLife;

    private final String imei;

    private Color color;

    private Material material;

    public class Contact {

        private final String id;
        private String firstName;
        private String lastName;
        private String phoneNumber;

        public Contact(String id, String firstName, String lastName, String phoneNumber) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
        }

        public String getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Contact id: ")
              .append(id)
              .append(" - First Name: ")
              .append(firstName)
              .append(" - Last Name: ")
              .append(lastName)
              .append(" - Phone Number: ")
              .append(phoneNumber)
              .append("\n");
            return sb.toString();
        }
    }

    public Phone( String imei, Color color, Material material) {
        this.imei = imei;
        this.color = color;
        this.material = material;
        this.messages = new HashMap<>();
        this.history = new ArrayList<>();
        this.contacts = new ArrayList<>();
    }


    public int getBatteryLife() {
        return batteryLife;
    }

    public String getImei() {
        return imei;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    @Override public void addContact(String id, String firstName, String lastName, String phoneNumber) {
        if(!isPhoneRunning()){
            return;
        }
        Contact contact = new Contact(id, firstName, lastName, phoneNumber);
        contacts.add(contact);
        System.out.println(contact+" was added!");
    }

    @Override public void listContacts() {
        if(!isPhoneRunning()){
            return;
        }
        if (contacts.isEmpty())
            System.out.println("No contacts!");
        else
            contacts.forEach(System.out::println);
    }

    @Override public void viewHistory() {
        if(!isPhoneRunning()){
            return;
        }
        if(history.isEmpty())
            System.out.println("No call history");
        else
            history.forEach(System.out::println);
    }

    @Override public void call(String phoneNumber) {
        if(!isPhoneRunning()){
            return;
        }
        if(batteryLife < 120){
            System.out.println("Calling "+phoneNumber+" ...\n Battery depleted closing phone...!");
            batteryLife = 0;
            return;
        }else{
            System.out.println("Calling "+phoneNumber+" ...\n");
            batteryLife -= 120;
        }
        if(batteryLife == 0){
            System.out.println("Battery depleted!");
        }

    }

    @Override public void sendMessage(String phoneNumber, String message) {
        if(!isPhoneRunning()){
            return;
        }
        if(message.length()>500){
            System.out.println("Message is too long! Must be at most 500 characters\n");
            return;
        }
        if(batteryLife < 60){
            System.out.println("Sending message: "+message +"\n To: "+phoneNumber+"\n");
            batteryLife =0;
        }else{
            System.out.println("Sending message: "+message +"\n To: "+phoneNumber+"\n");
            batteryLife -= 60;
        }
        List<String> messageList = messages.get(phoneNumber);
        if(messageList == null){
            messageList = new ArrayList<>();
            messageList.add(message);
            messages.put(phoneNumber,messageList);
        }else{
            messageList.add(message);
        }
        if(batteryLife == 0){
            System.out.println("Battery depleted!");
        }
    }

    @Override public void listMessages(String phoneNumber) {
       if(messages.isEmpty())
           System.out.println("No messages!");
       else{
           List<String> phoneNumberMessages = messages.get(phoneNumber);
           if(phoneNumberMessages==null){
               System.out.println("No messages for phone number: "+phoneNumber);
           }else{
               System.out.println("Messages for phone number:"+phoneNumber);
               phoneNumberMessages.forEach(System.out::println);
           }
       }
           messages.forEach((number,messages)->{
               System.out.println("Messages for phone number:"+number);
               messages.forEach(System.out::println);
           });
    }

    boolean isPhoneRunning(){
        if(batteryLife == 0){
            System.out.println("Phone is turned off!...");
            return false;
        }
        return true;

    }


}
