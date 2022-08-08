package AlgorithmsBook;

import edu.princeton.cs.algs4.StdDraw;

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

    protected static void draw(String[] a, int row, int ith, int jth) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(-2.50, row, ith + "");
        StdDraw.text(-1.25, row, jth + "");
        for (int i = 0; i < a.length; i++) {
            if (i == jth)      StdDraw.setPenColor(StdDraw.BOOK_RED);
            else if (i > ith)  StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else if (i < jth)  StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else               StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(i, row, a[i]);
        }
    }

    // display header
    protected static void header(String[] a) {
        int n = a.length;

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(n/2.0, -3, "a[ ]");
        for (int i = 0; i < n; i++)
            StdDraw.text(i, -2, i + "");
        StdDraw.text(-2.50, -2, "i");
        StdDraw.text(-1.25, -2, "j");
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(-3, -1.65, n - 0.5, -1.65);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++)
            StdDraw.text(i, -1, a[i]);
    }

    // display footer
    protected static void footer(String[] a) {
        int n = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++)
            StdDraw.text(i, n, a[i]);
    }
}
