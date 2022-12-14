package com.gad.java.rares.assignments.oop_principles_1.models;

public class Album extends Book{

    private Quality paperQuality;

    public Album(String name, int noOfPages, Quality paperQuality) {
        super(name, noOfPages);
        this.paperQuality = paperQuality;
    }

    public enum Quality{
        HIGH_TICKNESS,
        HIGH_OPACITY,
        HIGH_BRIGHTNESS,
        STANDARD,
        SMOOTH,
        ROUGH
    }

    public Quality getPaperQuality() {
        return paperQuality;
    }

    public void setPaperQuality(Quality paperQuality) {
        this.paperQuality = paperQuality;
    }

    @Override
    public void explain() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Novel Name: %s, ", this.name));
        sb.append(String.format("Number of Pages: %d, ",this.noOfPages));
        sb.append(String.format("Type: %s\n",this.paperQuality));

        System.out.println(sb);
    }
}
