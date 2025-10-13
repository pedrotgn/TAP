package reflection;

import java.lang.reflect.Field;

public class MainReflection {
    public static void main(String[] args) throws Exception {
        Car c = new Car("Tesla", "Model 3", 2022, 18500.75);

        Class<?> clazz = c.getClass();
        Field[] fields = clazz.getDeclaredFields();

        System.out.print("Field values: ");
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            Object value = fields[i].get(c);
            System.out.print(fields[i].getName() + " = " + value);
            if (i < fields.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
}
