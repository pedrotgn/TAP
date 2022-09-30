package observer;

/**
 * Created by pedro on 10/7/16.
 */
public class BinaryObserver implements Observer{



    @Override
    public void update(int newState) {
        System.out.println( "Binary String: " + Integer.toBinaryString(newState));
    }
}
