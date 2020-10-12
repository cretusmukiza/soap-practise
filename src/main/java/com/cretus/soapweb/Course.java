package com.cretus.soapweb;

import java.math.BigInteger;

public class Course {
    private int id;
    private String name;
    private String description;

    public Course(int id,String name, String description){
        this.description = description;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course [description=" + description + ", id=" + id + ", name=" + name + "]";
    }
}
