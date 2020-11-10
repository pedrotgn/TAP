package generics;

public class Thing<T> {
    private T name;

    public Thing(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public void setName(T nombre) {
        this.name = name;
    }
}
