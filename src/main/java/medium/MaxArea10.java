package medium;

import java.util.Arrays;

/**
 * @author Zumin Li
 * @date 2025/6/13 16:57
 */
public class MaxArea10 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;

        while (left <= right) {
            res = Math.max(res, area(height, left, res));

            // 移动左指针
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }

        return res;
    }

    private int area(int[] height, int start, int end) {
        return (end - start) * Math.min(height[start], height[end]);
    }
}
