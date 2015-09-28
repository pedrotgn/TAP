package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by pedro on 9/25/15.
 */
public class InspectTest {

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class aClass =Class.forName("reflection.Person");
        Method nameMethod=aClass.getDeclaredMethod("getName");
        Object newObject = aClass.newInstance();
        String output =(String) nameMethod.invoke(newObject);
        System.out.println(output);

        Person p1 = (Person)newObject;
        System.out.println(p1.getName());


        for (Method method:aClass.getDeclaredMethods())
            System.out.println(method.getName());

    }
}
