package solutions.filter2;

public class IsOdd implements IFilter<Integer> {
    @Override
    public boolean apply(Integer elem) {
        return elem % 2 == 0;
    }
}
