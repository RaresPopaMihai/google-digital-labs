package com.gad.java.rares.assignments.oop_principles_2.app;

import com.gad.java.rares.assignments.oop_principles_2.models.Material;
import com.gad.java.rares.assignments.oop_principles_2.models.Phone;
import com.gad.java.rares.assignments.oop_principles_2.models.Samsung;
import com.gad.java.rares.assignments.oop_principles_2.models.appleModels.Iphone15ProMax;
import com.gad.java.rares.assignments.oop_principles_2.models.appleModels.IphoneSE;
import com.gad.java.rares.assignments.oop_principles_2.models.samsungModels.SamsungCorby;
import com.gad.java.rares.assignments.oop_principles_2.models.samsungModels.SamsungGalaxyS20;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Phone phone= new Samsung(); // shouldn't compile
        List<Phone> phones = new ArrayList<>(5);
        phones.add(new SamsungGalaxyS20("SGS201", Color.BLACK, Material.Metal));
        phones.add(new SamsungCorby("SCBY15", Color.ORANGE, Material.Cardboard));
        phones.add(new Iphone15ProMax("AIP15PM1", Color.PINK, Material.Metal));
        phones.add(new Iphone15ProMax("AIP15PM2", Color.BLACK, Material.Metal));
        phones.add(new IphoneSE("AIPSEPM9", Color.MAGENTA, Material.Glass));

        phones.get(3).addContact("1", "John", "Doe", "0712345678");
        phones.get(3).addContact("2", "John", "Jones", "0700112233");
        phones.get(4).addContact("3", "John", "Cena", "0798989808");
        phones.get(2).addContact("4", "John", "Travolta", "0739123421");
        phones.get(1).addContact("5", "John", "Snow", "0799887754");
        phones.get(0).addContact("6", "Johnny", "Bravo", "0766231521");

        phones.forEach(Phone::listContacts);

        phones.get(3).sendMessage(phones.get(3).getContacts().get(0).getPhoneNumber(),
                                  "Sending a message...");
        phones.get(3).call(phones.get(3).getContacts().get(1).getPhoneNumber());

        phones.get(3).viewHistory();
        phones.get(3).listMessages(phones.get(3).getContacts().get(0).getPhoneNumber());

        phones.get(3).call(phones.get(3).getContacts().get(1).getPhoneNumber());
        phones.get(3).call(phones.get(3).getContacts().get(1).getPhoneNumber());
        phones.get(3).call(phones.get(3).getContacts().get(1).getPhoneNumber());
        phones.get(3).call(phones.get(3).getContacts().get(1).getPhoneNumber());
        phones.get(3).call(phones.get(3).getContacts().get(1).getPhoneNumber());
        phones.get(3).viewHistory();

    }

}
