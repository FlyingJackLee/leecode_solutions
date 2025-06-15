package AlgorithmsBook.Graph;

public class DepthFirstSearch {
    private boolean[] marked; // 标记每个点是否寻找过
    private int count;

    // 从点s开始搜索
    public DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;

        // 继续搜索相邻点
        for (int w: G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
