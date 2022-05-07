import java.util.Stack;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/13 2:00 PM
 * 4
 */
public class NumIslands200 {

    public static void main(String[] args) {
        char[][] grid =  {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(numIslands(grid));
    }

     public static int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int sum = 0;

         for (int i = 0; i < grid.length; i++) {
             for (int j = 0; j < grid[0].length; j++) {
                 if (grid[i][j] == '1' && visited[i][j] == 0){
                     sum++;
                     dfs(i,j,grid,visited);
                 }
             }
         }

         return sum;

     }

     public static void dfs(int x,int y, char[][] grid, int[][] visited){

         if (grid[x][y] == '1' && visited[x][y] == 0){

             visited[x][y] = 1;

             if ( y - 1 >= 0){
                 dfs(x,y-1,grid,visited);
             }

             if (y + 1 < grid[0].length){
                 dfs(x,y+1,grid,visited);
             }

             if (x + 1 < grid.length){
                 dfs(x+1,y,grid,visited);
             }

             if (x-1 >= 0){
                 dfs(x-1,y,grid,visited);
             }

         }



     }


//    public static int numIslands(char[][] grid) {
//
//        int[][] visited = new int[grid.length][grid[0].length];
//
//        int sum = 0;
//
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                //跳过访问的点
//                if (visited[i][j] == 1){
//                    continue;
//                }
//
//                if (grid[i][j] == '1'){
//                    sum++;
//
//                    Stack<Integer> pathX = new Stack<>();
//                    Stack<Integer> pathY = new Stack<>();
//                    //初始化路径
//                    pathX.push(i);
//                    pathY.push(j);
//
//                    //标记初始点已经访问
//                    visited[i][j] = 1;
//
//                    loop:
//                    while (!pathX.isEmpty()){
//                        int x = pathX.peek();
//                        int y = pathY.peek();
//
//                        int[] offsetX = {0,0,1,-1};
//                        int[] offsetY = {1,-1,0,0};
//
//                        for (int k = 0; k < offsetY.length; k++) {
//                            int neighbourX = offsetX[k] + x;
//                            int neighbourY = offsetY[k] + y;
//
//                            //超过边界跳过
//                            if (neighbourX < 0 || neighbourY < 0 || neighbourX >= grid.length || neighbourY >= grid[0].length){
//                                continue;
//                            }
//
//
//                            if (grid[neighbourX][neighbourY] == '1' && visited[neighbourX][neighbourY] == 0){
//                                pathX.push(neighbourX);
//                                pathY.push(neighbourY);
//
//                                visited[neighbourX][neighbourY] = 1;
//                                continue loop;
//                            }
//
//                            //标记已经访问
//                            visited[neighbourX][neighbourY] = 1;
//
//                        }
//
//                        pathX.pop();
//                        pathY.pop();
//
//
//                    }
//
//
//                }
//
//            }
//        }
//
//        return sum;
//    }
}
