import Week1.ListNode;
import Week1.Q1_10;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static Week1.Q1_10.*;
/**
 * 2 * @Author: flyingjack
 * 3 * @Date: 2021/7/20 6:07 pm
 * 4
 */
public class Q1_10_Test {

//    long startTime;
//    long startMemory;
//
//
//    @Before
//    public void before(){
//        startTime = System.nanoTime();
//        Runtime runtime = Runtime.getRuntime();
//        startMemory = runtime.totalMemory() - runtime.freeMemory();
//    }
//
//    @After
//    public void after(){
//        long endTime = System.nanoTime();
//        Runtime runtime = Runtime.getRuntime();
//
//        long afterMemory = runtime.totalMemory() - runtime.freeMemory();
//
//        String time = String.valueOf((double)(endTime - startTime)/1000000);
//        String memory = String.valueOf((double)(afterMemory-startMemory)/1024/1024) ;
//        System.out.println("---------------The total runtime："
//                + time.substring(0,time.equals("0.0") ? 1 : (time.indexOf(".")+3))
//                + " ms, consume memory：" +
//                memory.substring(0,memory.equals("0.0") ? 1 : (memory.indexOf(".")+3))
//                + " M !---------------");
//
//    }

    Q1_10 q1_10 = new Q1_10();

    @Test
    public void twoSumTest(){

        int[] sums = new int[]{3,2,3};
        int input = 6;

        assertArrayEquals(twoSum(sums,input),new int[]{0,2});

        sums = new int[]{-3,4,3,90};
        input = 0;
        assertArrayEquals(twoSum(sums,input),new int[]{0,2});

        sums = new int[]{3,3};
        input = 6;
        assertArrayEquals(twoSum(sums,input),new int[]{0,1});

        sums = new int[]{2,7,11,15};
        input = 9;
        assertArrayEquals(twoSum(sums,input),new int[]{0,1});

    }


    @Test
    public void addTwoNumbersTest(){
        ListNode l1 = new ListNode(2,
                new ListNode(4,
                        new ListNode(3)));

        ListNode l2 = new ListNode(5,
                new ListNode(6,
                        new ListNode(4)));


        ListNode result = q1_10.addTwoNumbers(l1,l2);

        int val = result.val;
        assertEquals(7,val);
        result = result.next;
        val = result.val;
        assertEquals(0,val);
        result = result.next;
        val = result.val;
        assertEquals(8,val);

         l1 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9)))))));

         l2 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9))));

         result = q1_10.addTwoNumbers(l1,l2);

         val = result.val;
        assertEquals(8,val);
        result = result.next;
        val = result.val;
        assertEquals(9,val);
        result = result.next;
        val = result.val;
        assertEquals(9,val);
        result = result.next;
        val = result.val;
        assertEquals(9,val);
        result = result.next;
        val = result.val;
        assertEquals(0,val);
        result = result.next;
        val = result.val;
        assertEquals(0,val);
        result = result.next;
        val = result.val;
        assertEquals(0,val);
        result = result.next;
        val = result.val;
        assertEquals(1,val);
    }
}
