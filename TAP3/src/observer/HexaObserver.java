package observer;

/**
 * Created by pedro on 10/7/16.
 */
public class HexaObserver implements Observer{


    @Override
    public void update(int newState) {
        System.out.println( "Hex String: " + Integer.toHexString( newState ).toUpperCase() );
    }
}