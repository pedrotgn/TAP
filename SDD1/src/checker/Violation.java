package checker;

/** One broken convention, found in one class. */
public class Violation {
    private final String rule;
    private final String className;
    private final String message;

    public Violation(String rule, String className, String message) {
        this.rule = rule;
        this.className = className;
        this.message = message;
    }

    public String getRule() {
        return rule;
    }

    public String getClassName() {
        return className;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "[" + rule + "] " + className + ": " + message;
    }
}
