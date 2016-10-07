package observer;

/**
 * Created by pedro on 10/7/16.
 */
public class OctalObserver extends Observer{


    @Override
    public void update(int newState) {
        System.out.println( "Octal String: " + Integer.toOctalString(newState) );
    }
}
