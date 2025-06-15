package AlgorithmsBook.Graph;

import DS.Bag;
import DS.In;

public class Graph {
    private final int V; // count of vertex
    private int E; // count of edge
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.nextInt());
        int E = in.nextInt();
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    // 返回某个点的度数: 相邻点的个数
    public static int degree(Graph g, int v) {
        int degree = 0;
        for (int w: g.adj(v)) {
            degree++;
        }
        return degree;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(new In("data/tinyG.txt"));
        System.out.println();
    }
}
