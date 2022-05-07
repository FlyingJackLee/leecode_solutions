/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/2 7:56 PM
 * 4
 */
public class Rotate189 {
    public void rotate(int[] nums, int k) {
        int l = 0;
        int r = nums.length - k;

        int[] result = new int[nums.length];


        for (int i = 0; i < k - 1; i++) {
            result[i] = nums[r + i];

        }



    }

    public void swap(int[] nums,int pre,int next){
        int temp = nums[pre];
        nums[pre] = next;
        nums[next] = temp;
    }

}
