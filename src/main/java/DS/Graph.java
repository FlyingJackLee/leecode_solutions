package DS;

import java.util.Iterator;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/24 16:07
 * 4
 */
public class Graph {
    private final int V;//顶点数量
    private int E;//边的数量
    private Bag<Integer>[] adj;//临接表

    public Graph(int V){
        this.V = V;
        this.E = 0;

        adj = new Bag[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public Graph(In in){
        this.V = in.nextInt();
        this.E = in.nextInt();

        adj = new Bag[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }

        //添加边
        while (in.hasNext()){
            addEdge(in.nextInt(),in.nextInt());
        }

    }



    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }


    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(new In("/Users/jack/Desktop/leecode/src/main/java/DS/graph.txt"));
        System.out.println(graph);
    }
}
