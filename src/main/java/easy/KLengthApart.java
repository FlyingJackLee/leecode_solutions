package easy;

public class KLengthApart {
    public boolean kLengthApart(int[] nums, int k) {
        int l = 0;


        while (l < nums.length - 1) {
            int r =  l + 1;

            // 不是1的时候
            if (nums[l] != 1) {
                l++;
                continue;
            }

            while (r < nums.length && nums[r] != 1) {
                r++;
            }


            if (r < nums.length && nums[r] != 0 && r - l  - 1< k) return false;
            l ++;
        }

        return true;
    }

    public static void main(String[] args) {
        KLengthApart kLengthApart = new KLengthApart();
        System.out.println(kLengthApart.kLengthApart(new int[]{1,0,0,0,1,0,0,1}, 2));
    }
}
