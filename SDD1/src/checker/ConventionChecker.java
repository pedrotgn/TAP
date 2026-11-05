package checker;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Checks the conventions of the steering file against the compiled classes.
 *
 * Usage: java checker.ConventionChecker <classes-dir> <package-prefix>
 * Example: java -cp out/main checker.ConventionChecker out/main bookstore
 *
 * Related lab: TAP 4 (reflection).
 */
public class ConventionChecker {
    private final List<Rule> rules = new ArrayList<>();

    public ConventionChecker(Collection<Rule> rules) {
        this.rules.addAll(rules);
    }

    public static ConventionChecker withDefaultRules() {
        return new ConventionChecker(DefaultRules.all());
    }

    public List<Violation> check(Collection<Class<?>> types) {
        List<Violation> violations = new ArrayList<>();
        for (Class<?> type : types) {
            for (Rule rule : rules) {
                rule.check(type, violations);
            }
        }
        return violations;
    }

    /** Loads every class under classesDir whose name starts with packagePrefix. */
    public static List<Class<?>> loadClasses(Path classesDir, String packagePrefix)
            throws IOException, ClassNotFoundException {
        URLClassLoader loader = new URLClassLoader(new URL[]{classesDir.toUri().toURL()});
        List<String> names;
        try (Stream<Path> files = Files.walk(classesDir)) {
            names = files
                    .filter(p -> p.toString().endsWith(".class"))
                    .map(p -> classesDir.relativize(p).toString())
                    .map(s -> s.substring(0, s.length() - ".class".length()))
                    .map(s -> s.replace('/', '.').replace('\\', '.'))
                    .filter(n -> n.startsWith(packagePrefix + "."))
                    .sorted()
                    .collect(Collectors.toList());
        }
        List<Class<?>> classes = new ArrayList<>();
        for (String name : names) {
            classes.add(Class.forName(name, false, loader));
        }
        return classes;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: ConventionChecker <classes-dir> <package-prefix>");
            System.exit(2);
        }
        List<Class<?>> classes = loadClasses(Paths.get(args[0]), args[1]);
        List<Violation> violations = withDefaultRules().check(classes);
        System.out.println("Checked " + classes.size() + " classes in '" + args[1] + "'.");
        for (Violation v : violations) {
            System.out.println("  " + v);
        }
        System.out.println(violations.isEmpty()
                ? "No violations."
                : violations.size() + " violation(s).");
        System.exit(violations.isEmpty() ? 0 : 1);
    }
}
