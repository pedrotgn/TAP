package solutions.filter2;

public class StartsWithCapital implements IFilter<String> {
    @Override
    public boolean apply(String elem) {
        char c = elem.charAt(0);
        return Character.isUpperCase(c);
    }
}
