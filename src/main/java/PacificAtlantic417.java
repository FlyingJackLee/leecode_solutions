import java.util.*;

public class PacificAtlantic417 {
//    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
//        List<List<Integer>> result = new ArrayList<>();
//        for (int r = 0; r < heights.length; r++) {
//            for (int c = 0; c < heights[0].length; c++) {
//                boolean[][] marked = new boolean[heights.length][heights[0].length];
//                boolean[] isFlow = new boolean[2];
//                dfs(heights, marked, r, c ,isFlow);
//
//                if (isFlow[0] && isFlow[1]) {
//                    result.add(Arrays.asList(r, c));
//                }
//            }
//        }
//        return result;
//    }
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    int[][] heights;

//    private List<List<Integer>> pacificAtlantic(int[][] heights) {
//        this.m = heights.length;
//        this.n = heights[0].length;
//        this.heights = heights;
//
//        boolean[][] pacific = new boolean[m][n];
//        boolean[][] atlantic = new boolean[m][n];
//        // 从边界反向搜索可以到达的点，并记录
//        for (int i = 0; i < m; i++) {
//            bfs(i, 0, pacific);
//        }
//        for (int j = 1; j < n; j++) {
//            bfs(0, j, pacific);
//        }
//        for (int i = 0; i < m; i++) {
//            bfs(i, n - 1, atlantic);
//        }
//        for (int j = 0; j < n - 1; j++) {
//            bfs(m - 1, j, atlantic);
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (pacific[i][j] && atlantic[i][j]) {
//                    result.add(Arrays.asList(i , j));
//                }
//            }
//        }
//        return result;
//    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m = heights.length;
        this.n = heights[0].length;
        this.heights = heights;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            dfs2(r, 0, pacific);
            dfs2(r, n -1, atlantic);

        }
        for (int c = 0; c < n; c++) {
            dfs2(0, c, pacific);
            dfs2(m - 1, c, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i , j));
                }
            }
        }
        return result;
    }

    private void dfs2(int r, int c, boolean[][] marked) {
        if (marked[r][c]) {
            return;
        }
        marked[r][c] = true;

        for(int[] dir: dirs) {
            int rOffset = r + dir[0];
            int cOffset = c + dir[1];

            if (rOffset >=0 && rOffset < m && cOffset >=0 && cOffset < n
                    && heights[rOffset][cOffset] >= heights[r][c] // 高度要更高
                    && !marked[rOffset][cOffset]
            ){
                dfs2(rOffset, cOffset, marked);
            }
        }
    }

    public void bfs(int row, int col, boolean[][] marked) {
        if (marked[row][col]) {
            return;
        }
        marked[row][col] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] coors = queue.poll();
            for (int[] dir: dirs) {
                int rOffset = coors[0] + dir[0];
                int cOffset = coors[1] + dir[1];
                if (rOffset >=0 && rOffset < m && cOffset >=0 && cOffset < n
                        && heights[rOffset][cOffset] >= heights[coors[0]][coors[1]] // 高度要更底
                        && !marked[rOffset][cOffset]
                ){
                    marked[rOffset][cOffset] = true;
                    queue.offer(new int[]{rOffset, cOffset });
                }

            }
        }
    }

    private static void dfs1(int[][] heights, boolean[][] marked, int r, int c, boolean[] isFlow) {
        // 如果访问过, 停止
        if (marked[r][c]){
            return;
        }

        marked[r][c] = true;
        // 如果相邻Pacific
        if (r == 0 || c == 0) {
            isFlow[0] = true;
        }
        // 如果相邻Atlantic
        if (r == heights.length - 1 || c ==  heights[0].length -1) {
            isFlow[1] = true;
        }

        if (!isFlow[0] || !isFlow[1]){
            int[] adjOffsetR = {0 , -1 , 0, 1};
            int[] adjOffsetC = {-1 , 0 , 1, 0};

            // 开始dfs查找相邻点
            for (int i = 0; i < 4; i++) {
                int rOffset = r + adjOffsetR[i];
                int cOffset = c + adjOffsetC[i];

                // 对有效点继续进行搜索
                if (rOffset >=0 && rOffset <= heights.length - 1
                        && cOffset >=0 && cOffset <= heights[0].length - 1
                        && heights[rOffset][cOffset] <= heights[r][c] // 高度要更底
                ){
                    dfs1(heights, marked, rOffset, cOffset, isFlow);
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        int[][] heights = {{1,1}, {1,1}, {1,1}};

        PacificAtlantic417 obj = new PacificAtlantic417();
        System.out.println(obj.pacificAtlantic(heights));
    }
}
