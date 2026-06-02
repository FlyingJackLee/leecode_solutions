package easy;

public class Check1752 {
    public static boolean check(int[] nums) {
        int n = nums.length - 1;


        int targetPoint = 0;
        int i = 0;

        for (; i < n; i++) {
            if (nums[i + 1] < nums[i]) {
                if (targetPoint == 0)  {
                    targetPoint = i + 1;
                } else {
                    return false;
                }
            }
        }

        if (nums[n] > nums[0] && targetPoint != 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(check(new int[]{3,4,5,1,2}));
    }
}
