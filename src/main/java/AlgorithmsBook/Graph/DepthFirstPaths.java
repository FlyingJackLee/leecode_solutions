package AlgorithmsBook.Graph;

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s; // 起点

    public DepthFirstPaths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
    }

    // 搜索从v出发的最深的点
    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w: g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;  // 标记当前点的起点
                dfs(g, w);
            }
        }
    }

    // 从s出发能不能到v
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    // 查询某个点到起点的路径
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();
        // 不停往前追溯, 将所有点放入路径
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
