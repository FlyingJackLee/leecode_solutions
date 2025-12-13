package AlgorithmsBook;

public class SortTemplate {

    protected boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    //change positions of two elements
    protected void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // does v == w ?
    protected static boolean eq(Comparable v, Comparable w) {
        if (v == w) return true;    // optimization when reference equal
        return v.compareTo(w) == 0;
    }

    protected void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
        System.out.println();
    }

    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }



    // is v < w ?
    private static boolean less(String v, String w) {
        return v.compareTo(w) < 0;
    }

}
