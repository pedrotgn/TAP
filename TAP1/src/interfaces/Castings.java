package interfaces;

/**
 * Created by pedro on 9/9/15.
 */
public class Castings {

    public static void main(String[] args) {

        Object o1 = new Thing();
        Bop b = (Bop)o1;
        b.dance();
        Musician m = (Musician)o1;
        m.sing();
        Musician m2 = (Musician)b;
        b.dance();



    }


}

