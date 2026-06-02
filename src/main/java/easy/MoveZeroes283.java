package easy;

import java.util.Arrays;

public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;

        while (right < n){
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left ++;
            }
            right++;
        }
    }

//    public void moveZeroes(int[] nums) {
//        int zeroPosition = -1;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                zeroPosition = zeroPosition >= 0 && zeroPosition < i
//                        ? zeroPosition : i;
//            } else {
//                if (zeroPosition >= 0){
//                    nums[zeroPosition] = nums[i];
//                    nums[i] = 0;
//
//                    zeroPosition = nums[zeroPosition + 1] == 0  ? zeroPosition + 1 : i;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        MoveZeroes283 alg = new MoveZeroes283();
        alg.moveZeroes(
                new int[]{0,1,0,3,12}
        );
        System.out.println();
    }

//    public void moveZeroes(int[] nums) {
//        int[] ans = new int[nums.length];
//
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0){
//                ans[j++] = nums[i];
//            }
//        }
//
//        for (; j < nums.length; j++) {
//            ans[j] = 0;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = ans[i];
//        }
//    }
}
