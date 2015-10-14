package observer;

/**
 * Created by pedro on 10/14/15.
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
