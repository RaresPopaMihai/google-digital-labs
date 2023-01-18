package com.gad.java.rares.assignments.io.model;

import java.io.Serializable;

public class Athlete implements Serializable, Comparable<Athlete> {
    private final int number;
    private String name;
    private String country;
    private String time;
    private int shotsMade;
    private String modifiedTime;

    public Athlete(int number, String name, String country, String time, int shotsMade) {
        this.number = number;
        this.name = name;
        this.country = country;
        this.time = time;
        this.shotsMade = shotsMade;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getTime() {
        return time;
    }

    public int getShotsMade() {
        return shotsMade;
    }

    public void setShotsMade(int shotsMade) {
        this.shotsMade = shotsMade;
    }

    @Override public String toString() {
        if(modifiedTime!=null){
            return this.name+" "+modifiedTime+" ("+time+" + "+(15-shotsMade)*10+")";
        }
        return this.name+" "+time+" ("+time+" + "+0+")";
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime=modifiedTime;
    }

    @Override public int compareTo(Athlete o) {
        if(this.modifiedTime != null){
            if(o.getModifiedTime() != null){
                return this.modifiedTime.compareTo(o.getModifiedTime());
            }
            return this.modifiedTime.compareTo(o.getTime());
        }else{
            if(o.getModifiedTime() != null){
                return this.time.compareTo(o.getModifiedTime());
            }
            return this.time.compareTo(o.getTime());
        }
    }
}
