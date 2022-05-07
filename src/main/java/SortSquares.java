import java.util.Arrays;
import java.util.List;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/2 7:34 PM
 * 4
 */
public class SortSquares {
    public  static  int[] sortedSquares(int[] nums) {
       int l = 0;
       int r = nums.length - 1;

       int[] result = new int[nums.length];
       int p = result.length - 1;

       while (l<=r){
           int left = nums[l] * nums[l];
           int right = nums[r] * nums[r];

           if (left > right){
               result[p] = left;
               p--;
               l++;
           }
           else{
               result[p] = right;
               p--;
               r--;
           }
       }

       return result;

    }

    public static void main(String[] args) {
        int[] test = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(test)));
    }
}
