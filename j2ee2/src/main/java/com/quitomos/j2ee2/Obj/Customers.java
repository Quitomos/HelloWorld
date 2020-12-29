package com.quitomos.j2ee2.Obj;

public class Customers {
    private int id;
    private String name;
    private String city;

    public Customers(String name, String city, int id) {
        this.name = name;
        this.city = city;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }
}
