package AlgorithmsBook.Graph;

public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC (Graph g) {
        marked = new boolean[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (!marked[i]) {
                dfs(g, i);
                count++; // 如果上一次dfs没有跑到这个点，意味着，这个点还存在着另外的联通分量，所以需要+1
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w: g.adj(v)) {
            if(!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
