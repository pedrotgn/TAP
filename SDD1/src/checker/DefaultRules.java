package checker;

import bookstore.exception.BookStoreException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * The conventions of steering/01-example-steering.md that can be checked by
 * looking at the structure of the classes.
 */
public final class DefaultRules {
    private DefaultRules() {
    }

    public static List<Rule> all() {
        List<Rule> rules = new ArrayList<>();
        rules.add(new ThrowableConventions());
        rules.add(new FindReturnsOptionalOrCollection());
        rules.add(new ServicesUseConstructorInjection());
        rules.add(new NoPublicMutableFields());
        rules.add(new MoneyInCents());
        return rules;
    }

    /** Every error type extends BookStoreException and its name ends with "Exception". */
    public static class ThrowableConventions implements Rule {
        public String name() {
            return "errors";
        }

        public void check(Class<?> type, List<Violation> violations) {
            if (!Throwable.class.isAssignableFrom(type)) {
                return;
            }
            if (!BookStoreException.class.isAssignableFrom(type)) {
                violations.add(new Violation(name(), type.getName(),
                        "must extend BookStoreException"));
            }
            if (!type.getSimpleName().endsWith("Exception")) {
                violations.add(new Violation(name(), type.getName(),
                        "name must end with 'Exception'"));
            }
        }
    }

    /** Methods called find* never return a bare object (which could be null). */
    public static class FindReturnsOptionalOrCollection implements Rule {
        public String name() {
            return "no-null-results";
        }

        public void check(Class<?> type, List<Violation> violations) {
            for (Method m : type.getDeclaredMethods()) {
                if (m.isSynthetic() || !m.getName().startsWith("find")) {
                    continue;
                }
                Class<?> returned = m.getReturnType();
                boolean safe = Optional.class.isAssignableFrom(returned)
                        || Collection.class.isAssignableFrom(returned);
                if (!safe) {
                    violations.add(new Violation(name(), type.getName(),
                            m.getName() + "() must return Optional or a collection, not "
                                    + returned.getSimpleName()));
                }
            }
        }
    }

    /** Classes in a "service" package only have private final fields. */
    public static class ServicesUseConstructorInjection implements Rule {
        public String name() {
            return "constructor-injection";
        }

        public void check(Class<?> type, List<Violation> violations) {
            if (!type.getPackage().getName().endsWith(".service")) {
                return;
            }
            for (Field f : type.getDeclaredFields()) {
                int m = f.getModifiers();
                if (Modifier.isStatic(m) || f.isSynthetic()) {
                    continue;
                }
                if (!Modifier.isPrivate(m) || !Modifier.isFinal(m)) {
                    violations.add(new Violation(name(), type.getName(),
                            "field '" + f.getName() + "' must be private final"));
                }
            }
        }
    }

    /** No public fields, except constants (public static final). */
    public static class NoPublicMutableFields implements Rule {
        public String name() {
            return "no-public-fields";
        }

        public void check(Class<?> type, List<Violation> violations) {
            for (Field f : type.getDeclaredFields()) {
                int m = f.getModifiers();
                boolean constant = Modifier.isStatic(m) && Modifier.isFinal(m);
                if (Modifier.isPublic(m) && !constant) {
                    violations.add(new Violation(name(), type.getName(),
                            "field '" + f.getName() + "' must not be public"));
                }
            }
        }
    }

    /** Fields about money are long and their name ends with "Cents". */
    public static class MoneyInCents implements Rule {
        public String name() {
            return "money-in-cents";
        }

        public void check(Class<?> type, List<Violation> violations) {
            for (Field f : type.getDeclaredFields()) {
                String lower = f.getName().toLowerCase();
                if (!lower.contains("price") && !lower.contains("amount")) {
                    continue;
                }
                if (f.getType() != long.class || !f.getName().endsWith("Cents")) {
                    violations.add(new Violation(name(), type.getName(),
                            "money field '" + f.getName()
                                    + "' must be a long and end with 'Cents'"));
                }
            }
        }
    }
}
