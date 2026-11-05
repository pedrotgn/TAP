package checker;

import bookstore.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConventionCheckerTest {

    private static Path classesDir() throws Exception {
        // The directory that holds the compiled production classes.
        return Paths.get(Book.class.getProtectionDomain().getCodeSource().getLocation().toURI());
    }

    private static List<Violation> run(String packagePrefix) throws Exception {
        List<Class<?>> classes = ConventionChecker.loadClasses(classesDir(), packagePrefix);
        Assert.assertFalse("no classes found for " + packagePrefix, classes.isEmpty());
        return ConventionChecker.withDefaultRules().check(classes);
    }

    @Test
    public void bookstorePackage_followsAllConventions() throws Exception {
        List<Violation> violations = run("bookstore");
        Assert.assertTrue(violations.toString(), violations.isEmpty());
    }

    @Test
    public void legacyPackage_breaksSeveralConventions() throws Exception {
        Set<String> rulesBroken = new HashSet<>();
        for (Violation v : run("legacy")) {
            rulesBroken.add(v.getRule());
        }
        Assert.assertTrue(rulesBroken.contains("errors"));
        Assert.assertTrue(rulesBroken.contains("no-null-results"));
        Assert.assertTrue(rulesBroken.contains("no-public-fields"));
        Assert.assertTrue(rulesBroken.contains("money-in-cents"));
    }
}
