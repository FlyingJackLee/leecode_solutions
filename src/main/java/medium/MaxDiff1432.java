package medium;

/**
 * @author Zumin Li
 * @date 2025/6/15 11:20
 */
public class MaxDiff1432 {
    public static int maxDiff(int num) {
        String nums = String.valueOf(num);

        String max = null;
        for (int i = 0; i < nums.length(); i++) {
            if (nums.charAt(i) != '9' && max == null) {
                max = nums.replace(nums.charAt(i), '9');
                break;
            }
        }
        max = max == null ? nums : max;

        // 1. 首位换成1
        String min = null;
        if (nums.charAt(0) != '1') {
            min = nums.replace(nums.charAt(0), '1');
        } else {
            // 2. 后面找一与首位不一样的换成0
            for (int i = 1; i < nums.length(); i++) {
                if (nums.charAt(i) != nums.charAt(0) && nums.charAt(i) != '0') {
                    min = nums.replace(nums.charAt(i), '0');
                    break;
                }
            }
        }
        min = min == null ? nums : min;

        return Integer.parseInt(max) - Integer.parseInt(min);
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(1101057));
    }
}
