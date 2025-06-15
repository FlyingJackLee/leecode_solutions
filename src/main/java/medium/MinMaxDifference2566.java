package medium;

import java.util.Arrays;

/**
 * @author Zumin Li
 * @date 2025/6/14 12:17
 */
public class MinMaxDifference2566 {
    public static int minMaxDifference(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int increase = 0;
        int decrease = 0;

        int highNonNine = -1;
        int firstDigital =  Character.getNumericValue(nums[0]);

        // 找到第一个高位非9
        for (int i = 0; i < nums.length; i++) {
            int digital = Character.getNumericValue(nums[i]);

            if (digital != 9 && highNonNine == -1) {
                highNonNine = Character.getNumericValue(nums[i]);
            }

            if (digital == highNonNine){
                increase += (int) Math.pow(10, nums.length - i - 1) * (9 - digital);
            }
            if (digital == firstDigital){
                decrease += (int) Math.pow(10, nums.length - i - 1) * firstDigital;
            }
        }


        return increase + decrease;
    }

    public static void main(String[] args) {
        System.out.println(minMaxDifference(90));
    }
}
