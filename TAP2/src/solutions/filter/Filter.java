package solutions.filter;

import java.util.ArrayList;

public class Filter {
    public static int[] filter(int[] lista, IFilter function) {
        int k = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i < lista.length; i++) {
            if (function.apply(lista[i])) {
                arrayList.add(lista[i]);
            }
        }

        int[] arr = new int[arrayList.size()];
        int i = 0;
        for (int elem: arrayList) {
            arr[i++] = elem;
        }

        return arr;
    }
}
