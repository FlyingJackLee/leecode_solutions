import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/2/27 6:23 PM
 * 4
 */
public class SolutionDay1 {
    public int search(int[] nums, int target) {
        //左边界
        int l = 0;
        //有边界
        int r = nums.length - 1;

        while (l <= r){

            //中点
            int m = (l + r) / 2;

            if (nums[m] == target){
                return m;
            }
            else if (nums[m] > target){
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] test = {-1,0,3,5,9,12};
        Arrays.binarySearch(test,9);

        System.out.println(Arrays.toString(test));

    }
}
