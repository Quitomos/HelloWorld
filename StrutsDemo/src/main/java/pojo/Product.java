package pojo;


import java.util.Date;

public class Product {
    private int id;
    private String name;

    public Product(){
        System.out.println("constructor");
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
}
