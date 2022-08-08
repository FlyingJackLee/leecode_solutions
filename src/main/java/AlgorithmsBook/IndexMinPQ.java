package AlgorithmsBook;

public class IndexMinPQ<T extends Comparable<T>> {

    private int n;
    private int[] pq; // store the index number with heap - from 1
    private int[] qp; // reversed pq, help to check if the index has value
    private T[] items; // store the elements using the index order;

    public IndexMinPQ(int capacity) {
        items = (T[]) new Comparable[capacity];
        pq = new int[capacity];
        qp = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            qp[i] = -1;
        }
        n = 0;

    }

    public boolean isEmpty(){
        return n == 0;
    }

    public boolean contains(int k){
        return qp[k] != -1;
    }

    public void change(int k, T item){

        items[k] = item;

        sink(pq[k]);
        swim(pq[k]);

    }

    public void insert(int k, T item){
        //record the index
        pq[++n] = k;
        qp[k] = n;

        //store the item
        items[k] = item;

        swim(k);
    }

    public int delMin(){
        int indexOfMin = pq[1];
        exch(1,n--);
        sink(1);

        //clear the last element
        items[pq[n+1]] = null;
        qp[pq[n+1]] = -1;

        return indexOfMin;
    }

    private void sink(int k){
        while (k*2 <= n ){
            //find the lager child
            int j = (k*2 < n && less(k*2,k*2+1))
                    ? k*2+1 : k*2;

            //already smaller child
            if (less(j,k)){
                break;
            }

            exch(j,k);

            k = j;
        }
    }

    private void swim(int k){
        while (k > 1 && less(k/2, k) ){
            exch(k,k/2);
            k = k/2;
        }
    }

    /***************************************************************************
     * Helper functions.
     ***************************************************************************/
    private boolean less(int i, int j) {
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    private boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];

        pq[i] = pq[j];
        pq[j] = swap;

        qp[pq[i]] = qp[qp[j]];
        qp[pq[j]] = qp[qp[i]];

    }



}
