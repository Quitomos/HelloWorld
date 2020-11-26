package Basic.Animal;

public abstract  class Animal {
    protected int legs;
    protected Animal(int _legs) {
        this.legs = _legs;
    }
    protected Animal() {}
    public abstract void eat();
    public void walk() {
        System.out.println("The animal walks with " + legs + " legs");
    }
}
