package easy;

import java.util.ArrayList;
import java.util.List;

public class Generate118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < numRows ; i++) {
            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < i +1; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j));
                }
            }
            dp.add(temp);
        }

        return dp;
    }

}
