import java.util.Arrays;

public class MaxWidthOfVerticalArea1637 {
    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);

        int maxLength = 0;
        for (int i = 0; i < points.length - 1; i++) {
            maxLength = Math.max(points[i+1][0] - points[i][0], maxLength);
        }

        return maxLength;
    }
}
