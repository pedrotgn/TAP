package observer;

/**
 * Created by pedro on 10/7/16.
 */
public class OctalObserver implements Observer{


    @Override
    public void update(int newState) {
        System.out.println( "Octal String: " + Integer.toOctalString(newState) );
    }
}
