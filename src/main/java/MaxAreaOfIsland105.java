import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/11 9:16 PM
 * 4
 */
public class MaxAreaOfIsland105 {
    //迭代法
    public static int maxAreaOfIsland(int[][] grid) {

        int[][] visited = new int[grid.length][grid[0].length];
        int biggestSum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //如果x,y 里面存了数字，表示访问过,跳过
                if (visited[i][j] == 1){
                    continue;
                }

                //设置访问过
                visited[i][j]= 1;

                //如果是陆地开始查找
                if (grid[i][j] == 1){

                    //储存路径用的stack
                    Stack<Integer> stackX = new Stack<>();
                    Stack<Integer> stackY = new Stack<>();

                    stackX.push(i);
                    stackY.push(j);

                    //储存path的stack
                    Stack<int[]> path = new Stack<>();
                    path.push(new int[]{i,j});

                    int[] offsetX = {0,0,1,-1};
                    int[] offsetY ={1,-1,0,0};

                    int sum = 1;

                    loop:
                    while (!path.isEmpty()){
                        int x = path.peek()[0];
                        int y = path.peek()[1];

                        //遍历上下四个点
                        for (int k = 0; k < 4; k++) {
                            int neighbourX = x+offsetX[k];
                            int neighbourY = y+offsetY[k];

                            if (neighbourX < 0 || neighbourY < 0
                                    || neighbourX >= grid.length || neighbourY >= grid[0].length) {
                                continue;
                            }


                            if (    //是陆地
                                    grid[neighbourX][neighbourY] == 1 &&
                                            //没有遍历过
                                            visited[neighbourX][neighbourY] == 0
                            ){
                                //设置访问过
                                visited[neighbourX][neighbourY] = 1;


                                stackX.push(neighbourX);
                                stackY.push(neighbourY);

                                sum++;
                                //强行到下一个循环
                                continue loop;

                            }
                        }

                        //当周围的点没有1或者遍历完了
//                        stackX.pop();
//                        stackY.pop();

                        path.pop();


                    }

                    biggestSum = Math.max(sum,biggestSum);

                }

            }
        }

        return biggestSum;
    }



    //递归法
//    public static int maxAreaOfIsland(int[][] grid) {
//
//        int[][] visited = new int[grid.length][grid[0].length];
//        int biggestSum = 0;
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                //如果x,y 里面存了数字，表示访问过,跳过
//                if (visited[i][j] == 1){
//                    continue;
//                }
//
//                //设置访问过
//                visited[i][j]= 1;
//
//                //如果是陆地开始查找
//                if (grid[i][j] == 1){
//                    int sum = dfs(i,j,grid,visited);
//                    biggestSum = Math.max(biggestSum,sum);
//                }
//
//            }
//        }
//
//        return biggestSum;
//
//    }

    public static int dfs(int x, int y,int[][] grid, int[][] visited){

        int sum = 1;

        int[] offsetX = {0,0,1,-1};
        int[] offsetY ={1,-1,0,0};

        for (int k = 0; k < offsetY.length; k++) {
            int neighbourX = x + offsetX[k];
            int neighbourY = y + offsetY[k];

            if (neighbourX < 0 || neighbourY < 0
                    || neighbourX >= grid.length || neighbourY >= grid[0].length) {
                continue;
            }


            if (    //是陆地
                    grid[neighbourX][neighbourY] == 1 &&
                            //没有遍历过
                            visited[neighbourX][neighbourY] == 0
            ){
                visited[neighbourX][neighbourY] = 1;
                //每进去一层 + 1
                sum += dfs(neighbourX,neighbourY,grid, visited);;

            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int[][] test = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(test));

    }
}
