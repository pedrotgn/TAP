package defaultmethods;

/**
 * Created by pedro on 26/10/14.
 */
public interface ICorrupt {
    public default void blackCard(){
        System.out.println("spending money ...");
    }

    public static void spendLikeCrazy(){
        System.out.println("Restaurants, parties, vacations, ...");
    }
}
