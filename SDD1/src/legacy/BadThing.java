package legacy;

/** Old error type used by the legacy code. */
public class BadThing extends RuntimeException {
    public BadThing(String message) {
        super(message);
    }
}
