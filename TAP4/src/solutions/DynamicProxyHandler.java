package solutions;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {

    private final Object target;

    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method called: " + method.getName());
        if (args != null) {
            for (Object arg : args) {
                System.out.println("Parameter: " + arg);
            }
        }

        Object result = method.invoke(target, args);

        Method realMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
        Bonus bonus = realMethod.getAnnotation(Bonus.class);
        if (bonus != null && result instanceof Number) {
            result = ((Number) result).doubleValue() + bonus.value();
        }

        return result;
    }
}
