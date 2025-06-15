package medium;

import java.util.Arrays;

/**
 * @author Zumin Li
 * @date 2025/6/13 1:46
 */
public class MinCapability2560 {
    private int[] f;
    private int[] g;


    public int minCapability(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();
        int upper = Arrays.stream(nums).max().getAsInt();

        while (lower <= upper) {
            int middle = (lower + upper) / 2;

            int count = 0;

            boolean visitedNeighbor = false; // 用于不断切换+1元素
            for (int x: nums) {
                if (x <= middle && !visitedNeighbor) {
                    count ++;
                    visitedNeighbor = true;
                } else { // 有两种情况回到这里，一是x太大，二是visited为true，也就是刚刚便利相邻元素
                    visitedNeighbor = false;
                }
            }
            // 遍历完以后，就可以找到小于既定threshold的个数了

            if (count >= k) { // 如果达标了
                upper = middle - 1; // 压缩threshold，继续寻找
            } else {
                lower = middle + 1; // 未达标，证明threshold取小了
            }
        }


        return lower;
    }
}
