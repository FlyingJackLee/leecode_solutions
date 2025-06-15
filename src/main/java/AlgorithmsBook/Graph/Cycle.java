package AlgorithmsBook.Graph;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(JavaFriendlyGraph graph) {
        marked = new boolean[graph.getV()];
        for (int i = 0; i < graph.getV(); i++) {
            if (!marked[i]) {
                dfs(graph, i, i);
            }
        }
    }

    private void dfs(JavaFriendlyGraph g, int v, int u) {
        marked[v] = true;
        for(int w: g.getAdj(v)) {
            if (!marked[w]) {
                dfs(g, w, v);
            }
            // 如果访问过，并且不相等，证明又回到原来去过的地方了，即有环
            else if (w != u) {
                hasCycle = true;
            }
        }
    }
}
