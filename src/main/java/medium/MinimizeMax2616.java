package medium;

import java.util.Arrays;

/**
 * 原题目是查找p对（最小差值）的最大值
 * 先排序
 * 这里的方法是逆向思维 - 通过最小差值解答：
 *      设置一个最小差值threshold
 *      然后贪心遍历所有小于threshold的对数
 *      如果他的对数大于等于p，证明取得threshold太大了（越大的threshold就会容纳更多的对数）
 *      然后我们就可以降低threshold
 * 上诉过程很明显适合用二分查找降低查找次数
 *
 * @author Zumin Li
 * @date 2025/6/13 0:26
 */
public class MinimizeMax2616 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int threshold = (left + right) / 2;

            int count = 0;
            int index = 0;
            while (index < nums.length - 1) {
                if (nums[index + 1] - nums[index] <= threshold ) {
                    count++;
                    index += 2;
                } else {
                    index++;
                }
            }

            if (count >= p ){
                right = threshold;
            } else {
                left = threshold + 1;
            }
        }

        return left;
    }

    // Find the number of valid pairs by greedy approach
    private int countValidPairs(int[] nums, int threshold) {
        int index = 0, count = 0;
        while (index < nums.length - 1) {
            // If a valid pair is found, skip both numbers.
            if (nums[index + 1] - nums[index] <= threshold) {
                count++;
                index++;
            }
            index++;
        }
        return count;
    }
}
