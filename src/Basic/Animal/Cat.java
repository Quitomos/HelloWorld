package Basic.Animal;

import Basic.A;

public class Cat extends Animal implements Pet {
    private String name;


    public Cat(String _name) {
        super(4);
        setName(_name);
    }

    public Cat() {
        this("");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void play() {
        System.out.println("A cat is playing");
    }

    @Override
    public void eat() {
        System.out.println("A cat is eating");
    }
}
