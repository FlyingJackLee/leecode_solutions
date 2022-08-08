package AlgorithmsBook;

import java.util.Arrays;
import java.util.function.Consumer;

public class MergeBottomToTopSort extends SortTemplate implements Consumer<Comparable[]> {
    private Comparable[] aux;

    @Override
    public void accept(Comparable[] a) {
        int n = a.length;
        this.aux = new Comparable[n];

        for (int sizeOfSubarray = 1; sizeOfSubarray < n; sizeOfSubarray *= 2) {
            for (int lowOfSubarray = 0; lowOfSubarray < n-sizeOfSubarray;
                 lowOfSubarray += sizeOfSubarray * 2) {
                //the mid must be the low add the size, because the high may be revised as n,
                // which means the bound between left and right may be wrong!!!
                int mid = lowOfSubarray + sizeOfSubarray - 1;
                this.merge(a, lowOfSubarray, mid,
                        Math.min(lowOfSubarray + sizeOfSubarray*2 - 1, n - 1));
            }
        }
    }

    public void merge(Comparable[] a, int lo,int mid, int hi){
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        //record the index of element has been used in left or right part.
        int leftUseIndex = lo;
        int rightUseIndex = mid + 1;

        for (int k = lo; k <= hi ; k++) {
            //we have used all elements in left part, only use right
            if (leftUseIndex > mid){
                a[k] = aux[rightUseIndex++];
            }
            else if (rightUseIndex > hi){
                a[k] = aux[leftUseIndex++];
            }
            else if (less(aux[leftUseIndex],aux[rightUseIndex])){
                a[k] = aux[leftUseIndex++];
            }
            else {
                a[k] = aux[rightUseIndex++];
            }

        }
    }
}
