package AlgorithmsBook;

import java.util.ArrayList;
import java.util.List;

public class CountPairs2316 {
    private List<Integer>[] adj;
    private boolean[] marked;

    public long countPairs(int n, int[][] edges) {
        this.adj = new ArrayList[n];
        this.marked = new boolean[n];

        for (int i = 0; i < n; i++) {
            this.adj[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            this.adj[edge[0]].add(edge[1]);
            this.adj[edge[1]].add(edge[0]);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            // 如果还未访问过（该连通分量未访问过）
            if (!this.marked[i]) {
                long count = dfs(i); // 连通分量，顶点个数
                result += count * (n - count); // 每个顶点都有相同的未连接顶点数
            }
        }
        return result / 2;
    }

    // 返回v所在连通分量的顶点个数
    private long dfs(int v) {
        marked[v] = true;

        long size = 1;
        for (int w: adj[v]) {
            if (!marked[w]) {
                size += dfs(w);
            }
        }
        return size;
    }


        //***
    // union find 解法
//    private int[] id;
//    private int[] sz; // 这里的sz其实就是连通分量的大小2
//
//    public long countPairs(int n, int[][] edges) {
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
//        long result = 0;
//        for (int i = 0; i < n; i++) {
//            result += n - sz[find(i)];
//        }
//        return result / 2;
//    }
//
//    private int find(int v) {
//        while (id[v] != v ) {
//            id[v] = id[id[v]];
//            v = id[v];
//        }
//        return v ;
//    }
//
//    private void union(int v, int w) {
//        int vRoot = find(v);
//        int wROot = find(w);
//
//        if (vRoot == wROot) return ;
//
//        if (sz[wROot] > sz[vRoot] ) {
//            id[vRoot] = wROot;
//            sz[wROot] += sz[vRoot];
//        } else {
//            id[wROot] = vRoot;
//            sz[vRoot] += sz[wROot];
//        }
//    }
//

    public static void main(String[] args) {
        CountPairs2316 alg = new CountPairs2316();

//        int[][] edges = {{5,0},{1,0},{10,7},{9,8},{7,2},{1,3},{0,2},{8,5},{4,6},{4,2}};
        int[][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        System.out.println(alg.countPairs(7 ,edges));
    }
}
