package easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecentCounterTest {
    private RecentCounter counter = new RecentCounter();

    @Test
    public void test_case() {
        int[] input = {1,100,3001,3002};
        int[] output = {1,2,3,3};

        for (int i = 0; i < input.length; i++) {
            assertEquals(output[i], counter.ping(input[i]));
        }
    }
}