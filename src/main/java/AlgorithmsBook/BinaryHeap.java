package AlgorithmsBook;

public class BinaryHeap<T extends Comparable<T>> implements MaxPQ<T> {
    private T[] pq; //start from 1
    private int n;

    public BinaryHeap(int capacity) {
        this.pq =  (T[]) new Comparable[capacity];
        this.n = 0;
    }

    @Override
    public void insert(T ele) {
        pq[++n] = ele;
        swim(n);
    }

    private void swim(int k){
        //k/2 is the father node of k node.
        //this means the k node will swap with father node when it is smaller.
        while (k > 1 && less(k/2, k)){
            exch(k/2,k);
            k = k/2;
        }
    }

    @Override
    public T delMax() {
        T lastEle = pq[1];
        //move last one to first one
        exch(1,n--);

        //sink the first one
        sink(1);

        return lastEle;
    }

    private void sink(int k){
        while (2*k <= n ){
            int j = 2*k;

            if (j < n && less(j,j+1)){
                j++;
            }

            if (!less(k,j)){
                break;
            }
            exch(k,j);

            k=j;


        }
    }


    /*
        Help Methods
     */
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        T swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

}
