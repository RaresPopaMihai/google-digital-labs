package com.gad.java.rares.assignments.oop_principles_1.models;

import java.util.Objects;

public class Novel extends Book{

    private Type type;

    public Novel(String name, int noOfPages, Type type) {
        super(name, noOfPages);
        this.type = type;
    }

    public enum Type{
        EPISTOLARY,
        PICARESQUE,
        EXPERIMENTAL,
        N_OF_MANNERS,
        SENTIMENTAL,
        GOTHIC,
        HISTORICAL,
        SOCIAL_REALISM,
        PSYCHOLOGICAL
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void explain() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Novel Name: %s, ", this.name));
        sb.append(String.format("Number of Pages: %d, ",this.noOfPages));
        sb.append(String.format("Type: %s\n",this.type));

        System.out.println(sb);
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Novel novel = (Novel) o;
        return type == novel.type;
    }

    @Override public int hashCode() {
        return Objects.hash(type);
    }
}
