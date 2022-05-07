import java.util.ArrayList;
import java.util.List;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/11 10:41 PM
 * 4
 */
public class NumIslands2305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < positions.length; i++) {
            grid[positions[i][0]][positions[i][1]] = 1;
            result.add(numIsland(grid));
        }

        return result;
    }


    public int numIsland(int[][] grid){
        int[][] visited = new int[grid.length][grid[0].length];
        int sum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1 && visited[i][j] == 0 ){
                    dfs(i,j,grid,visited);
                    sum ++;
                }

                visited[i][j] = 1;


            }
        }

        return sum;
    }

    public void dfs(int x, int y,int[][] grid, int[][] visited){
        int[] offsetX = {0,0,1,-1};
        int[] offsetY = {1,-1,0,0};

        for (int i = 0; i < offsetX.length; i++) {
            int neighbourX = offsetX[i] + x;
            int neighbourY = offsetY[i] + y;

            if (neighbourX < 0 || neighbourY < 0
                    || neighbourX >= grid.length || neighbourY >= grid[0].length){
                continue;
            }

            if (grid[neighbourX][neighbourY] == 1 && visited[neighbourX][neighbourY] == 0){
                visited[neighbourX][neighbourY] = 1;
                dfs(neighbourX,neighbourY,grid,visited);
            }

        }

    }



}
