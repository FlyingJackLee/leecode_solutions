package AlgorithmsBook;

import java.util.function.Consumer;

public class SelectionSort extends SortTemplate implements Consumer<Comparable[]> {
    /*
     *
     * Complexity: N ^ 2
     *             ~ Find:  N + (N-1) + (N-2) + ..... + 1
     *             ~ Exchange: N
     */
    @Override
    public void accept(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                //If it is a less value, record the position.
                if (less(a[j],a[min])){
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }


}
