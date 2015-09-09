package exception;

/**
 * Created by pedro on 9/9/15.
 */
public class TapCourse {
    public static String passCourse(boolean hasStudied) throws TAPException{
        if (hasStudied) return "You pass the course";
        else {
            throw new TAPException("You failed, better study next time");
        }
    }

}
