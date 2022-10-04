package solutions.filter;

public class IsOdd implements IFilter{

    @Override
    public boolean apply(int elem) {
        return elem % 2 == 0;
    }
}
