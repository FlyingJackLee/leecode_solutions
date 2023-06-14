import org.junit.Test;

import static org.junit.Assert.*;

public class RotateString796Test {
    private RotateString796 alg = new RotateString796();

    @Test
    public void test_case_1() {
        String s = "abcde";
        String goal = "cdeab";
        assertTrue(alg.rotateString(s, goal));
    }
}