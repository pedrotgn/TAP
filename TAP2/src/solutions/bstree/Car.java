package solutions.bstree;

public class Car {
    String name;

    public Car(String name) {
        this.name = name;
    }

    public void claxon() {
        System.out.println("MEEEC");
    }

    @Override
    public String toString() {
        return name;
    }
}
