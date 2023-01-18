package com.gad.java.rares.assignments.object_containers.models;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private int streetNumber;
    private Country country;

    public Address(String city, String street, int streetNumber, Country country) {
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Address address = (Address) o;
        return streetNumber == address.streetNumber && Objects.equals(city, address.city) && Objects.equals(street,
                                                                                                            address.street) && Objects.equals(
                country, address.country);
    }

    @Override public int hashCode() {
        return Objects.hash(city, street, streetNumber, country);
    }

    @Override public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", country=" + country +
                '}';
    }
}
