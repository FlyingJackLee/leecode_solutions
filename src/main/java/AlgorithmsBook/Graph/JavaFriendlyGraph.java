package AlgorithmsBook.Graph;

import java.util.ArrayList;
import java.util.List;

public class JavaFriendlyGraph {
    private final int v; // 顶点个数
    private int e; // 边个数
    private List<Integer>[] adj; // 存放相邻（边）关系

    public JavaFriendlyGraph(int n) {
        this.e = 0; // 初始边个数为0
        this.v = n; // 设置顶点个数
        this.adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            this.adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int p, int q) {
        this.adj[p].add(q);
        this.adj[q].add(p);
        this.e++;
    }

    public int getE() {
        return e;
    }

    public int getV() {
        return v;
    }

    public Iterable<Integer> getAdj(int v) {
        return adj[v];
    }
}
