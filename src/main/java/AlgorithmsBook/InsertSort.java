package AlgorithmsBook;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.function.Consumer;

public class InsertSort extends SortTemplate implements Consumer<Comparable[]>  {

    /*
     *
     * Complexity:  N ^ 2
     *             ~ Compare:
     *                  (Terrible): 1 + 2 + ... + N = N(N-1)/2 ~ (N^2)/2
     *                  (Best): N - 1
     *                  (Average): ((N-1) + N(N-1)/2)/2 = (N+2)(N-1)/4 ~ (N^2)/4
     *             ~ Exchange: N
     *                  (Terrible): 1 + 2 + ... + N = N(N-1)/2 ~ (N^2)/2
     *                  (Best): 0
     *                  (Average): (0 + N(N-1)/2)/2 ~ (N^2)/4
     */
    @Override
    public void accept(Comparable[] a) {
        int N = a.length;

        //make a[0] as a sentinel
        for (int i = 1; i < N; i++) {
            if (less(a[i],a[0])){
                exch(a,i,0);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = i; less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }
}
