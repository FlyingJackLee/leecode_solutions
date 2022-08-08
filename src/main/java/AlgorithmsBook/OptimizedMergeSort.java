package AlgorithmsBook;

import java.util.function.Consumer;

public class OptimizedMergeSort extends SortTemplate implements Consumer<Comparable[]> {
    @Override
    public void accept(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        merge(a,0, a.length-1, aux);
    }

    public void merge(Comparable[] a, int low,int high,Comparable[] aux){

        if ( high<=low){
            return;
        }

        //use insert sort when the size is under 15
        if (high - low <= 15){
            int exchangeCount = 0;
            for (int i = high; i > low ; i--) {
                if (less(a[i], a[i-1])){
                    exch(a, i-1,i);
                    exchangeCount++;
                }
            }

            if (exchangeCount == 0){
                return;
            }

            for (int i = low + 2; i <= high; i++) {
                Comparable v = a[i];

                int j = i;
                for (; less(v,a[j - 1]); j--) {
                    a[j] = a[j - 1];
                }

                a[j] = v;
            }

            return;
        }


        //merge
        int mid = low + (high - low)/2;

        merge(a, low, mid, aux);
        merge(a, mid + 1, high, aux);

        //already sort
        if (less(a[mid],a[mid+1])){
            return;
        }

        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }

        int indexOfLeftPart = low;
        int indexOfRightPart = mid + 1;

        for (int k = low; k <= high; k++) {

            if (indexOfLeftPart > mid){
                a[k] = aux[indexOfRightPart++];
            }
            else if (indexOfRightPart > high){
                a[k] = aux[indexOfLeftPart++];
            }
            else if (less(aux[indexOfLeftPart],aux[indexOfRightPart])){
                a[k] = aux[indexOfLeftPart++];
            }
            else {
                a[k] = aux[indexOfRightPart++];
            }
        }

    }
}
