package com.gad.java.rares.assignments.io;

import com.gad.java.rares.assignments.io.model.Athlete;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    List<Athlete> athletes = new ArrayList<>();
    public static void main(String[] args) {
        List<Athlete> athletes = parseCSV();

        Collections.sort(athletes);
        showPodium(athletes);
    }

    private static void showPodium(List<Athlete> athletes) {
        StringBuilder podium = new StringBuilder();
        podium.append("Winner - ")
              .append(athletes.get(0))
              .append("\n")
              .append("Runner-Up - ")
              .append(athletes.get(1))
              .append("\n")
              .append("Third Place - ")
              .append(athletes.get(2));
        System.out.println(podium);
    }

    public static String getModifiedTime(int shotsMade, String time) {
        int secondsAdded = (15 - shotsMade)*10;
        if(secondsAdded == 0)
            return time;
        int seconds = Integer.parseInt(time.split(":")[1]);
        int minutes = Integer.parseInt(time.split(":")[0]);

        seconds+=secondsAdded;
        if(seconds >= 60 ){
            seconds -= 60;
            minutes++;
        }
        if(minutes>60){
            minutes-=60;
            if(seconds<10)
                return "1:"+minutes+":"+"0"+seconds;
            return "1:"+minutes+":"+seconds;
        }
        if(seconds<10)
            return minutes+":"+"0"+seconds;
        return minutes+":"+seconds;
    }

    public static int getShotsMade(String shootingRange1, String shootingRange2, String shootingRange3) {
        int shots=(int)shootingRange1.toUpperCase().chars().filter(ch->ch=='X').count();
        shots+=(int)shootingRange2.toUpperCase().chars().filter(ch->ch=='X').count();
        shots+=(int)shootingRange3.toUpperCase().chars().filter(ch->ch=='X').count();
        return shots;
    }

    public static List<Athlete> parseCSV(){
        List<Athlete> athletes = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("csvinput"+ File.separator+"input.csv"));) {
            String line = "";
            while((line = br.readLine()) != null){
                String[] attributes = line.split(",");
                int number = Integer.parseInt(attributes[0]);
                String name = attributes[1];
                String country = attributes[2];
                String time = attributes[3];
                int shotsMade = getShotsMade(attributes[4],attributes[5],attributes[6]);
                String modifiedTime = getModifiedTime(shotsMade, time);
                Athlete athlete = new Athlete(number,name,country,time,shotsMade);
                if(!modifiedTime.equals(time)){
                    athlete.setModifiedTime(modifiedTime);
                }
                athletes.add(athlete);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return athletes;
    }
}
