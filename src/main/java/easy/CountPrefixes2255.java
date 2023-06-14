package easy;

import java.util.Arrays;

public class CountPrefixes2255 {
    public int countPrefixes(String[] words, String s) {
        return (int) Arrays.stream(words).filter(s::startsWith).count();
    }
}
