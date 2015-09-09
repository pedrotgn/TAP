package functional;

/**
 * Created by pedro on 7/17/14.
 */
public class Animal {
    public Animal(int age) {
        this.age = age;
    }

    private int age;

    public void talk (){
        System.out.println("hola");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
