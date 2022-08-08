package AlgorithmsBook;

import edu.princeton.cs.algs4.StdRandom;

import javax.sound.midi.MidiFileFormat;
import java.util.function.Consumer;

public class QuickSort extends SortTemplate implements Consumer<Comparable[]> {
    final static int INSERT_SORT_TRIGGER_SIZE = 15;

    @Override
    public void accept(Comparable[] a) {
        quick(a,0,a.length -1);
    }

    private void quick(Comparable[] a, int lo, int hi){
        if (hi <=lo + INSERT_SORT_TRIGGER_SIZE) {
            OptimizedInsertSort insertSort = new OptimizedInsertSort();
            insertSort.sort(a, lo, hi);
            return;
        }

        int j = partition(a, lo, hi);

        quick(a, lo, j-1);
        quick(a, j+1, hi);

    }

    private int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi +1;
        Comparable v =  a[lo];

        while (true){
            while (less(a[++i], v)){
                if (i == hi){
                    break;
                }
            }

            while (less(v, a[--j])){
                if (j == lo){
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exch(a, i, j);
        }


        exch(a, lo, j);
        return j;
    }
}
