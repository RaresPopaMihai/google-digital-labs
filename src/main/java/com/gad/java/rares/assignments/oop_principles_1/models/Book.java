package com.gad.java.rares.assignments.oop_principles_1.models;

import com.gad.java.rares.assignments.oop_principles_1.interfaces.Explainer;

public abstract class Book implements Explainer {

    protected String name;
    protected int noOfPages;

    public Book(String name, int noOfPages) {
        this.name = name;
        this.noOfPages = noOfPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    @Override
    public abstract void explain();

}
