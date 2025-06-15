package AlgorithmsBook.Graph;

public class UnionFind {
    private int[] id;
    private int count;

    public UnionFind(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return this.count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // p 所在分量序号
    public int find(int p) {
        return id[p];
    }

    // 连接p和q
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        // 如果已经在一个分量中，直接返回
        if (pId == qId) return;

        // 根据传递性，需要将所有序号为pId联通分量中的所有序号合并到另一个分量中
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }

    // 快速查询法其实是利用链的方法
    // p 所在根节点
    public int quickFind(int p) {
        // 不停深入直到找到root节点
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        };
        return p;
    }

    public void quickUnion(int p, int q) {
        int pRoot = quickFind(p);
        int qRoot = quickFind(q);

        // 如果根节点相同的，证明是联通的，直接返回
        if (pRoot == qRoot) return;

        // 否则将两个分支相连
        id[pRoot] = qRoot;
        count--;
    }

    // 加权算法
    private int[] sz;

    public int weightedFind(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void weightedUnion(int p, int q) {
        int pRoot = weightedFind(p);
        int qRoot = weightedFind(q);

        if (pRoot == qRoot) return;

        // 总是链接到权重更大的分支上
        if (sz[pRoot] < sz[qRoot]) { id[pRoot] = qRoot; sz[qRoot] += sz[pRoot];  }
        else { id[qRoot] = pRoot; sz[pRoot] += sz[qRoot];  }

        count--;
    }
}
