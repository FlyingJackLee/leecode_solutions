package medium;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(
                s -> {
                    char[] cs = s.toCharArray();
                    Arrays.sort(cs);
                    return new String(cs);
                }
        )).values());
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams49().groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}
        ));
    }
}
