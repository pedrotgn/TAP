package functional;

/**
 * Created by pedro on 7/17/14.
 */
public class Animal {
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(String name,int age) {
        this.name = name;

        this.age = age;
    }

    private String name;
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
