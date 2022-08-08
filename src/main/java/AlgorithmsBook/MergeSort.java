package AlgorithmsBook;

import java.util.Arrays;
import java.util.function.Consumer;

public class MergeSort extends SortTemplate implements Consumer<Comparable[]>  {
    private Comparable[] aux;

    @Override
    public void accept(Comparable[] a) {
        this.aux =  new Comparable[a.length];
        merge(a,0,a.length-1);
    }

    public void merge(Comparable[] a, int lo, int hi){
        if (hi<=lo){
            return;
        }

        int mid = lo + (hi - lo)/2;

        merge(a,lo,mid);
        merge(a,mid + 1,hi);

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
