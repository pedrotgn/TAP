package exception;

/**
 * Created by pedro on 9/9/15.
 */
public class TAPMain {
    public static void main(String args[])  // throws TAPException
    {
        try{
            System.out.println(TapCourse.passCourse(false));
        } catch (TAPException e){
            System.out.println(e.getMessage());
        }

    }
}
