package solutions.rules;

import checker.Rule;
import checker.Violation;

import java.util.List;

/**
 * Solution to exercise 3: two more conventions written as rules.
 */
public final class ExtraRules {
    private ExtraRules() {
    }

    /** Every class in a "service" package has a name ending with "Service". */
    public static class ServiceNaming implements Rule {
        public String name() {
            return "service-naming";
        }

        public void check(Class<?> type, List<Violation> violations) {
            if (type.getPackage().getName().endsWith(".service")
                    && !type.getSimpleName().endsWith("Service")) {
                violations.add(new Violation(name(), type.getName(),
                        "classes in a service package must end with 'Service'"));
            }
        }
    }

    /** Every class in a "model" package declares its own toString(). */
    public static class ModelHasToString implements Rule {
        public String name() {
            return "model-to-string";
        }

        public void check(Class<?> type, List<Violation> violations) {
            if (!type.getPackage().getName().endsWith(".model")) {
                return;
            }
            try {
                type.getDeclaredMethod("toString");
            } catch (NoSuchMethodException e) {
                violations.add(new Violation(name(), type.getName(),
                        "model classes must override toString()"));
            }
        }
    }
}
