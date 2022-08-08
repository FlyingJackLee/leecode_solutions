package AlgorithmsBook;

import java.util.function.Consumer;

public class OptimizedInsertSort extends SortTemplate implements Consumer<Comparable[]> {

    /*
     *
     * Complexity:
     * (Details see code)
     *             ~ Compare:
     *                  N + (N+3)(N-2)/2 = (N^2+3n-6)/2 ~ (N^2)/2
     *             ~ Exchange + Half-exchange(half consume): N
     *                  N/2 + (N+1)(N-2)/2 / 2 = (N^2 - 2)/2 ~ (N^2)/2
     */
    @Override
    public void accept(Comparable[] a) {
       sort(a, 0, a.length-1);
    }

    public void sort(Comparable[] a, int low, int hi) {

        //1. find the smallest element and put it as a sentinel(head)
        /*
             * Complexity 1:
             ~ Compare:
                   N
             ~ Exchange:
                  (Terrible): N
                  (Best): 0
                  (Average): (0 + N)/2 ~ N/2
         */
        int exchange = 0;
        for (int i = hi; i > low; i--) {
            if (less(a[i],a[i-1])){
                exch(a, i, i - 1);
                exchange++;
            }
        }

        //if exchange never happen, it is already sorted.
        if (exchange == 0){
            return;
        }

         /*
             * Complexity 2:
             ~ Compare:
                  (Terrible): 2 + 3 + 4 ... + N = (N+1)(N-2)/2 ~ (N^2)/2
                  (Best): N - 2
                  (Average): (N+1)(N-2)/2 + (N-2) = (N+3)(N-2)/2 ~ (N^2)/2
             ~ Half-Exchange:
                  (Terrible):2 + 3 + 4 ... + N = (N+1)(N-2)/2 ~ (N^2)/2
                  (Best): 0
                  (Average): 0 +  (N+1)(N-2)/2 ~ (N^2)/2
         */
        for (int i = 2; i <= hi; i++) {
            //save the current exchange(because a[i] may be covered by smaller one)
            Comparable v = a[i];
            int j = i;
            //keep exchange until it get target position
            //on the other words - find the target position for current element
            while (less(v,a[j-1])){
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
        }
    }
}
