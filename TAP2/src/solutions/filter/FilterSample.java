package solutions.filter;

public class FilterSample {

    public static void main(String[] args) {
        int[] list = {0,1,2,3,4,5};

        int[] result = Filter.filter(list, new IsOdd());

        for (int i : result)
            System.out.println(i);

        System.out.println("---");


        int[] result2 = Filter.filter(list, new IsBiggerThan(3));
        for (int i : result2)
            System.out.println(i);

    }

}
