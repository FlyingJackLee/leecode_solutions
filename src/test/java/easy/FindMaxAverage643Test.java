package easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMaxAverage643Test {
    private FindMaxAverage643 alg = new FindMaxAverage643();

    @Test
    public void test_case1(){
        int[] nums = {0,1,1,3,3};
        int k = 4;
        assertEquals(2.0, alg.findMaxAverage(nums,k), 0.00);
    }
}