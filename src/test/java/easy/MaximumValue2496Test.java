package easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumValue2496Test {
    private MaximumValue2496 alg = new MaximumValue2496();

    @Test
    public void test_case() {
        String[] strs = {"alic3","bob","3","4","00000"};
        assertEquals(5, alg.maximumValue(strs));
    }
}