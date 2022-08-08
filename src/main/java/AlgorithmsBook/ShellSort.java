package AlgorithmsBook;

import java.util.function.Consumer;

public class ShellSort extends SortTemplate implements Consumer<Comparable[]> {

    @Override
    public void accept(Comparable[] a) {
        int n = a.length;

        int h = 1;
        while (h < n/3){
            h = 3*h + 1;
        }

        while (h >= 1){
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j],a[j-h]); j -= h) {
                    exch(a,j,j-h);
                }
            }
            h = h/3;
        }

    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        Integer[] testArr = {
                1,7,6,2,4,9,5,3
        };

        shellSort.accept(testArr);
        System.out.println();
    }
}
