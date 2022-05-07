import java.util.Arrays;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/2 8:51 PM
 * 4
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;

        //一次循环，当出现0的时候就不会增长left，也就是说left总是指向0的
        while (right < n){
            //当右指针指向非0时和左边交换
            if (nums[right] != 0){
                swap(nums,left,right);
                //左指针现在指向的不是0了，需要+1
                left++;
            }

           right ++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
