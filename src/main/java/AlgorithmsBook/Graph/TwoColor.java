package AlgorithmsBook.Graph;

public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(JavaFriendlyGraph graph) {
        marked = new boolean[graph.getV()];
        color = new boolean[graph.getV()];
    }

    private void dfs(JavaFriendlyGraph g, int v) {
        marked[v] = true;
        for(int w: g.getAdj(v)) {
            if (!marked[w]) {
                // 没有访问过的上色为前一个的反向色
                color[w] = !color[v];
                dfs(g, w);
            }
            // 任意访问过的edge上两个点颜色一致，证明二色失败
            else if (color[w] == color[v]) {
                isTwoColorable = false;
            }
        }

    }
}
