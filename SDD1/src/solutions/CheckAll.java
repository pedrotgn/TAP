package solutions;

import checker.ConventionChecker;
import checker.DefaultRules;
import checker.Rule;
import checker.Violation;
import solutions.rules.ExtraRules;

import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

/**
 * Runs the default rules plus the extra rules of exercise 3 on a package.
 * Usage: java -cp out/main solutions.CheckAll out/main bookstore
 */
public class CheckAll {
    public static void main(String[] args) throws Exception {
        List<Rule> rules = new ArrayList<>(DefaultRules.all());
        rules.add(new ExtraRules.ServiceNaming());
        rules.add(new ExtraRules.ModelHasToString());

        ConventionChecker checker = new ConventionChecker(rules);
        List<Class<?>> classes = ConventionChecker.loadClasses(Paths.get(args[0]), args[1]);
        List<Violation> violations = checker.check(classes);

        System.out.println("Checked " + classes.size() + " classes with " + rules.size() + " rules.");
        for (Violation v : violations) {
            System.out.println("  " + v);
        }
        System.out.println(violations.isEmpty() ? "No violations." : violations.size() + " violation(s).");
    }
}
