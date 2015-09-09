package defaultmethods;

/**
 * Created by pedro on 26/10/14.
 */
public interface IPerson {
    public void sayHello();
    public default void blackCard(){
        System.out.println("I have a black card");
    }
}
