import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CountSubIslands {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;

        int count = 0;

        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //是陆地并且没有访问过
                if (grid2[i][j] == 1 && visited[i][j] != 1 ){

                    boolean isSubIsland = true;

                    Stack<Integer> x_path  = new Stack<>();
                    Stack<Integer> y_path = new Stack<>();
                    x_path.add(i);
                    y_path.add(j);

                    visited[i][j] = 1;

                    path_loop:
                    while (!x_path.isEmpty()){
                        int x_curr = x_path.peek();
                        int y_curr = y_path.peek();

                        int[] offset_x = {0,0,1,-1};
                        int[] offset_y = {1,-1,0,0};


                        //是否有未访问的岛屿邻居
                        for (int k = 0; k < 4 ; k++) {
                            int x_neighbour = x_curr + offset_x[k];
                            int y_neighbour = y_curr + offset_y[k];

                            if (x_neighbour > m -1 || y_neighbour > n -1 || x_neighbour < 0 || y_neighbour < 0){
                                continue;
                            }

                            if (grid2[x_neighbour][y_neighbour] == 1 && visited[x_neighbour][y_neighbour] !=1 ){
                                x_path.add(x_neighbour);
                                y_path.add(y_neighbour);

                                visited[x_neighbour][y_neighbour] = 1;

                                //找到了，继续往下找
                                continue path_loop;
                            }
                        }

                        int x_end = x_path.pop();
                        int y_end = y_path.pop();

                        if (grid1[x_end][y_end] != 1){
                            isSubIsland = false;
                        }

                    }


                    if (isSubIsland){
                        count++;
                    }

                }

            }
        }


        return count;


    }


}
