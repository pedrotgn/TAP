package annotations;

/**
 * Created by pedro on 9/24/15.
 */


@Copyright(
        priority = Copyright.Priority.HIGH,
        createdBy = "pedro",
        tags = {"tap", "urv", "gei"}
)
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}



