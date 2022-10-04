package solutions.map3;

public class StringLength implements IMap3<String, Integer> {
    @Override
    public Integer apply(String elem) {
        return elem.length();
    }
}
