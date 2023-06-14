package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Intersection349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (Integer num: nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (Integer num: nums2) {
            set2.add(num);
        }

        return set1.size() < set2.size() ?
                set_intersection(set1, set2) : set_intersection(set2, set1);
    }

    public int[] set_intersection(Set<Integer> set1, Set<Integer> set2) {
        int[] output = new int[set1.size()];
        int idx = 0;
        for (Integer s:set1) {
            if (set2.contains(s)) {
                output[idx++] = s;
            }
        }

        return Arrays.copyOf(output, idx);
    }
}
