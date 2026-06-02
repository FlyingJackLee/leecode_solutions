package medium;

public class MaxArea11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;
        int left = 0, right = n - 1;

        while (left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}
