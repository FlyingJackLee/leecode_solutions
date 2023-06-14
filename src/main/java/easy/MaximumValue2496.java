package easy;

import java.util.Arrays;

public class MaximumValue2496 {
    public int maximumValue(String[] strs) {
        return Arrays.stream(strs).map(str -> {
            int result = -1;
            try {
                result = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                result = str.length();
            }
            return result;
        }).sorted().max(Integer::compareTo).get();
    }
}
