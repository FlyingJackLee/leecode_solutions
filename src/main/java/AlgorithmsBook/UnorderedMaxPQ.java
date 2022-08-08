package AlgorithmsBook;

public class UnorderedMaxPQ<T extends Comparable<T>> implements MaxPQ<T> {
    private T[] pq;
    private int n;

    public UnorderedMaxPQ(int capacity) {
        this.pq = (T[]) new Comparable[capacity];
        this.n = 0;
    }
    
    public boolean isEmpty(){
        return n == 0;
    }
    
    public int size(){
        return n;
    }

    @Override
    public void insert(T ele){
        this.pq[n++] = ele;
    }

    @Override
    public T delMax(){
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (less(max,i)){
                max = i;
            }
        }

        exch(max,n-1);

        return pq[--n];
    }

    /***************************************************************************
     * Helper functions.
     ***************************************************************************/
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        T swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

}
