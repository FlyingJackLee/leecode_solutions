package AlgorithmsBook;

import java.util.Arrays;
import java.util.function.Consumer;

public class HeapSort extends SortTemplate implements Consumer<Comparable[]> {

    @Override
    public void accept(Comparable[] pq) {
        int n =  pq.length;

        //let heap ordered
        for (int k = n/2; k >= 1; k--) {
            sink(pq, k, n);
        }

        int k = n;
        while (k > 1){
            exch(pq,1, k--);
            sink(pq,1, k);
        }

        for (int i = 0; i < 3; i++) {
            int j = i;
            while (j>0 && super.less(pq[j],pq[j-1])){
                super.exch(pq,j,j-1);
                j--;
            }
        }
    }

    private void sink(Comparable[] pq, int k, int n){
        while (k*2 <= n ){
            int j = k * 2;

            if (j < n && less(pq, j, j+1)){
                j++;
            }

            if (j >= n){ break;}

            if (!less(pq,k,j)){
                break;
            }

            exch(pq, k, j);

            k = j;
        }
    }

    private boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    @Override
    protected void exch(Comparable[] pq, int i, int j) {
        Comparable swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
}
