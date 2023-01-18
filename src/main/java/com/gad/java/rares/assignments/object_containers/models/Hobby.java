package com.gad.java.rares.assignments.object_containers.models;

import java.util.List;

public class Hobby {

    String name;
    int frequency;
    List<Address> addressList;

    public Hobby(String name, int frequency, List<Address> addressList) {
        this.name = name;
        this.frequency = frequency;
        this.addressList = addressList;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nThe hobby: ")
          .append(this.name)
          .append("\nIs practiced ")
          .append(this.frequency)
          .append(" times a week")
          .append("\nAt: ");
        this.addressList.forEach(address -> sb.append("\n - Street : ")
                                          .append(address.getStreet())
                                          .append(" Number:")
                                          .append(address.getStreetNumber())
                                          .append(" City: ")
                                          .append(address.getCity())
                                          .append(" Country: ")
                                          .append(address.getCountry().getName()));
        return sb.toString();
    }
}
