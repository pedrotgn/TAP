package structures;

/**
 * Created by pedro on 9/9/15.
 */
public class Person {
    String dni;
    String name;
    int age;

    @Override
    public String toString() {
        return "Person{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Person(String dni, String name, int age) {

        this.dni = dni;
        this.name = name;
        this.age = age;
    }
}
