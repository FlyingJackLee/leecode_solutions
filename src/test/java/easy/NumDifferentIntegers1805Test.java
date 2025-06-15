package easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumDifferentIntegers1805Test {
    final NumDifferentIntegers1805 alg = new NumDifferentIntegers1805();

    @Test
    public void test_case1() {
        String word = "a1b01c001";
        assertEquals(1, alg.numDifferentIntegers(word));
    }
}