package easy;

import java.util.Arrays;

public class NumDifferentIntegers1805 {
    public int numDifferentIntegers(String word) {
        return (int) Arrays.stream(word.split("[a-z]")).filter(s -> !s.isEmpty())
                .map(s -> s.replaceFirst("^0*", "")).distinct().count();
    }
}
