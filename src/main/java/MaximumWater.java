/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/1/23 9:30 PM
 * 4
 */
public class MaximumWater {
    public int maxArea(int[] height) {

        int pi = 0;
        int pj = height.length-1;

        int maxArea = 0;

        while (true){

            if (pi>=pj){
                break;
            }

            maxArea =
                   Math.max(
                            maxArea,
                           //较小值*长度
                           Math.min(height[pi],height[pj]) * (pj - pi)
                   );

            //移动较小边界
            if (height[pi]<height[pj]){
                pi +=1;
            }
            else {
                pj -=1;
            }

        }

        return maxArea;



//        int len = height.length;
//
//        int[][] dp = new int[len][len];
//
//        //1. 计算出所有长度为2的组合的最大值
//        //比如01,12,23 .....
//        for (int i = 0; i < len - 1; i++) {
//            dp[i][i+1] = Math.min(height[i], height[i + 1]);
//        }
//
//
//        //2. 从长度为3的开始遍历
//        for (int size = 3; size < len; size++) {
//            //2.1 从头开始遍历可能组合
//            for (int i = 0; i < len - size; i++) {
//                //边界条件小的最大值
//                int boundMax = Math.min(height[i],height[i+size-1]) * size;
//
//
//
//
//            }
//        }



    }
}
