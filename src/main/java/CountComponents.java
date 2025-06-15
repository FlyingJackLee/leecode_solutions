import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CountComponents {
//    private int[] id;
//    private int count;
//    private int[] sz;
//
//    public int countComponents(int n, int[][] edges) {
//        this.count = n;
//        this.id = new int[n];
//        this.sz = new int[n];
//        for (int i = 0; i < n; i++) {
//            this.id[i] = i;
//            this.sz[i] = 1;
//        }
//
//        for(int[] edge:edges) {
//            union(edge[0], edge[1]);
//        }
//
//        return count;
//    }
//
//    private int find(int p) {
//        while (id[p] != p) {
//            p = id[p];
//        }
//        return p;
//    }
//
//    private void union(int p, int q) {
//        int pRoot = find(p);
//        int qRoot = find(q);
//
//        if (pRoot == qRoot) return;
//
//        if (sz[pRoot] < sz[qRoot]) {
//            id[pRoot] = qRoot;
//            sz[qRoot] += sz[pRoot];
//        } else {
//            id[qRoot] = pRoot;
//            sz[pRoot] += sz[qRoot];
//        }
//        count--;
//    }

    private List<Integer>[] adj;
    private boolean[] marked;
    private int count;

    public int countComponents(int n, int[][] edges) {
        adj = new ArrayList[n];
        marked = new boolean[n];
        count = n;

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>(1);
        }
        for(int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            bfs(i);
        }
        return count;
    }

    private void dfs(int v) {
        marked[v] = true;

        for (Integer p: adj[v]) {
            if (!marked[p]) {
                count--;
                dfs(p);
            }
        }
    }

    private void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        marked[v] = true;

        while (!queue.isEmpty()) {
            int p = queue.poll();

            for (Integer q: adj[p]) {
                if (!marked[q]) {
                   queue.offer(q);
                   marked[q] = true;
                   count--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edge = new int[][]{{0, 1}, {1, 2}, {0, 2} ,{3, 4}};

        CountComponents alg = new CountComponents();
        System.out.println(alg.countComponents(n, edge));
    }
}
