package medium;
import java.util.*;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        Set<List<Integer>> ans = new HashSet<>();

        Arrays.sort(nums);

        while (right - left > 1) {
            int res = Arrays.binarySearch(Arrays.copyOfRange(nums, left + 1, right), - nums[right] - nums[left]);
            if (res >= 0) {
                ans.add(List.of(nums[left], nums[res + left + 1], nums[right]));
                left++;
                continue;
            }

            int insertPos = -(res + 1); //实际插入位置
            // 证明要找的值在数组
            if (insertPos > 0 && insertPos < n) {
                left++;
            } else {
                right--;
                left = 0;
            }
        }

        return ans.stream().toList();
    }

    public static void main(String[] args) {
        ThreeSum15 alg = new ThreeSum15();
        System.out.println(alg.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
