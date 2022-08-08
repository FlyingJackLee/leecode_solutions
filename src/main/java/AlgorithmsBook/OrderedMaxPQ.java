package AlgorithmsBook;

public class OrderedMaxPQ<T extends Comparable<T>> implements MaxPQ<T> {
    private T[] pq;
    private int n;

    public OrderedMaxPQ(int size) {
         this.pq = (T[]) new Comparable[size];
         n = 0;
    }

    @Override
    public void insert(T ele){
//        int max = n;
//        pq[n++] = ele;
//        for (int i = n - 1; i >= 0 && less(i,i-1) ; i--) {
//                exch(i,i-1);
//        }

        int i = n++;
        for (; i >= 1 && less(ele, pq[i-1]); i --) {
                pq[i] = pq[i-1];
        }
        pq[i] = ele;

    }
    @Override
    public T delMax(){
        return this.pq[--n];
    }


    /***************************************************************************
     * Helper functions.
     ***************************************************************************/
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    private void exch(int i, int j) {
        T swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

}
