public class NumDistinctIslands694 {

    private void dfs(int x, int y, boolean[][] marked) {
        if (marked[x][y]){
            return;
        }


    }
    
    static class Island implements Comparable<Island> {
        int[][] coors;

        @Override
        public int compareTo(Island o) {
            int offsetX = o.coors[0][0] - this.coors[0][0];
            int offsetY = o.coors[0][1] - this.coors[0][1];

            for (int i = 1; i < coors.length - 1; i++) {
                if (o.coors[i][0] - this.coors[i][0] != offsetX || o.coors[i][1] - this.coors[i][1] != offsetY) {
                    return -1;
                }
            }

            return 0;
        }
    }
}
