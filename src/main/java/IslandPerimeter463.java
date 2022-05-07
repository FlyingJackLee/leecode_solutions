import java.util.Stack;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/13 2:48 PM
 * 4
 */
public class IslandPerimeter463 {
    public int islandPerimeter(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int sum = 0;
        loop:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1){

                    Stack<Integer> pathX = new Stack<>();
                    Stack<Integer> pathY = new Stack<>();
                    pathX.push(i);
                    pathY.push(j);
                    visited[i][j] = 1;



                    while (!pathX.isEmpty()){

                        int contribution = 4;

                        int x = pathX.pop();
                        int y = pathY.pop();


                        int[] offsetX = {0,0,1,-1};
                        int[] offsetY = {-1,1,0,0};

                        for (int k = 0; k < offsetY.length; k++) {
                            int neighbourX = offsetX[k] + x;
                            int neighbourY = offsetY[k] + y;

                            if (neighbourX <0 || neighbourY <0 ||
                                neighbourX >= grid.length || neighbourY>= grid[0].length
                            )
                            {
                                continue;
                            }

                            //如果周围是陆地，则减去一个边的长度
                            if (grid[neighbourX][neighbourY] == 1){
                                contribution --;

                                //如果没有访问过，放入path中
                                if (visited[neighbourX][neighbourY] == 0){
                                    pathX.push(neighbourX);
                                    pathY.push(neighbourY);
                                    visited[neighbourX][neighbourY] = 1;
                                }
                            }
                        }

                        sum += contribution;

                    }
                    break loop;

                }

            }
        }

        return sum;

    }


}
