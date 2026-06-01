package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class insert57 {
    // target[0] >= megerd.getLast()[0]
    private static void merge(List<int[]> megerd, int[] target){
        if (megerd.isEmpty() || target[0] > megerd.getLast()[1]) {
            megerd.add(target);
        } else {
            int l =  Math.min(megerd.getLast()[0], target[0]);
            int r = Math.max(megerd.getLast()[1], target[1]);
            megerd.removeLast();
            megerd.add(new int[]{l, r});
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> megerd = new ArrayList<>(1);

        boolean isDealNew = false;

        for (int i = 0; i < intervals.length; i++) {
            // 如果当前的超过了target，需要先处理target
            if ((newInterval[0] < intervals[i][0]) && !isDealNew ) {
                merge(megerd, newInterval);
                isDealNew = true;
            }

            merge(megerd, intervals[i]);
        }

        if (!isDealNew) { merge(megerd, newInterval);}

        return megerd.toArray(new int[megerd.size()][]);
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(insert(new int[][]{
//                        new int[]{1, 3},
//                        new int[]{6, 9}
//                }, new int[]{2, 5}
//        )));

        System.out.println(Arrays.deepToString(insert(new int[][]{
                        new int[]{1, 5},
                }, new int[]{2, 7}
        )));

        System.out.println(Arrays.deepToString(insert(new int[][]{
                        new int[]{1, 5},
                }, new int[]{0, 0}
        )));
    }
}
