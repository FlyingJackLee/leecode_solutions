package AlgorithmsBook;

import edu.princeton.cs.algs4.StdRandom;

import java.util.function.Consumer;

public class OptimizedQuickSort extends SortTemplate implements Consumer<Comparable[]> {

    @Override
    public void accept(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int low, int high){
        if (low>=high){
            return;
        }

        int lt = low; // [low, lt-1] < v
        int gt = high;  // [gt+1, high] > v
        int i = low + 1 ; // [lt, i - 1] = v, we need make i - 1 = gt

        Comparable pivotElement = a[low];

        while (i <= gt){
            int compareResult = a[i].compareTo(pivotElement);
            if (compareResult < 0){
                exch(a,lt++,i++);
            } else if (compareResult > 0) {
                exch(a,gt--,i);
            }
            else {
                i++;
            }
        }
        sort(a,low,lt - 1);
        sort(a,gt + 1, high);

    }
}
