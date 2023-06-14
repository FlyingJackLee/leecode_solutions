package medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SmallestSubsequence1081Test {
    private SmallestSubsequence1081 alg = new SmallestSubsequence1081();

    @Test
    public void test_case() {
        assertEquals("abc", alg.smallestSubsequence("bcabc"));
        assertEquals("acdb", alg.smallestSubsequence("cbacdcbc"));
    }

    @Test
    public void test_helper() {
        assertEquals(3, Arrays.stream("bcabc".split("")).distinct().count());
        assertEquals(4, Arrays.stream("cbacdcbc".split("")).distinct().count());
    }
}