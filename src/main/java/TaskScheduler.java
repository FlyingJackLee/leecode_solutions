import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class TaskScheduler {
    private static int taskScheduler(int resourcesNum, int[][] taskAttributes) {
        //优先按照优先级排序
        Arrays.sort(
                taskAttributes, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[1] == o2[1]){
                            return o2[0] - o1[0];
                        }

                        return o1[1] - o2[1];
                    }
                }
        );

        int count = -1;
        int taskIndex = 0;

        //vm池子
        int[] vmPool = new int[resourcesNum];

        task_loop:
        while (true){
            count++;

            boolean isContinue = false;
            //执行过程模拟
            for (int i = 0; i < vmPool.length; i++) {

                //如果vm里面有任务，执行一秒
                if (vmPool[i] > 0){
                    vmPool[i] -= 1;
                }

                //vm空闲了，补上新的任务
                if (vmPool[i] == 0 && taskIndex <= taskAttributes.length -1){
                    vmPool[i] = taskAttributes[taskIndex][0];
                    taskIndex++;
                }

                if (vmPool[i] > 0 ){
                    isContinue = true;
                }

            }

            //判断是否全部任务执行完

            if (isContinue){
                continue task_loop;
            }

            //全部执行完停止循环
            break;
           }

        // 在此补充你的代码
        return count % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println( taskScheduler(4,new int[][]{

        }));
    }
}
