package tada.suzu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SimpleSort {

    public static void main(String... args) {
        int[] numbers = {-2,0,1,4,5,-8};

        ArrayList<Integer> numbersList = new ArrayList<Integer>();
        for(int n : numbers) {
            numbersList.add(n);
        }

        Comparator<Integer> c = (n1, n2) -> n1 - n2;

        Collections.sort(numbersList, c);

        for(int n : numbersList){
            System.out.print(n + " ");
        }
        System.out.println("\n");

    }
}
