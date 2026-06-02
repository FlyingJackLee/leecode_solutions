package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });

        List<int[]> merged = new ArrayList<>(1);
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > merged.getLast()[1] ) {
                merged.add(intervals[i]);
            } else {
                int left = Math.min(merged.getLast()[0], intervals[i][0]);
                int right = Math.max(merged.getLast()[1], intervals[i][1] );
                merged.removeLast();
                merged.add(new int[]{left, right});
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
