/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/15 2:07 PM
 * 4
 */
public class MaxProduct1464 {
    public int maxProduct(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int biggest = 0;

        while (left<right){
            int temp = (nums[left] - 1) * (nums[right] - 1);
            biggest = Math.max(temp,biggest);

            if (nums[left] < nums[right]){
                left ++;
            }
            else {
                right --;
            }
        }

        return biggest;
    }
}
