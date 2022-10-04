package solutions.filter;

public class IsBiggerThan implements IFilter {
    private int num;

    public IsBiggerThan(int num) {
        this.num = num;
    }

    @Override
    public boolean apply(int elem) {
        return elem > num;
    }
}
