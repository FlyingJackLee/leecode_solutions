import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CountDaysTogether2409Test {
    private CountDaysTogether2409 alg = new CountDaysTogether2409();

    @Test
    public void test_case1(){
        String arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19";
        assertEquals(3, alg.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }

    @Test
    public void test_case2(){
        String arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31";
        assertEquals(0, alg.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }

    @Test
    public void test_helper() {
        String test1 = "10-01", test2 = "10-31", test3 = "11-01";
        assertEquals(274, alg.strToDays(test1));
        assertEquals(304, alg.strToDays(test2));
        assertEquals(305, alg.strToDays(test3));
    }

}