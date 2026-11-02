package checker;

import java.util.List;

/**
 * A convention of the steering file, written as code.
 * A rule looks at one class (using reflection) and adds a Violation for each
 * problem it finds.
 */
public interface Rule {
    /** Short name, used in reports. */
    String name();

    void check(Class<?> type, List<Violation> violations);
}
