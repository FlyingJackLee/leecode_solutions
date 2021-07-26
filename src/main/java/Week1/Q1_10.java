package Week1;

import java.util.*;

/**
 * 2 * @Author: flyingjack
 * 3 * @Date: 2021/7/20 4:46 pm
 * 4
 */
public class Q1_10 {

    //https://leetcode.com/problems/two-sum/
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> offsetMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

           int offset = target - nums[i];

           //find if there is a relevant offset element.
           if (offsetMap.get(offset) != null){
               return new int[]{offsetMap.get(offset),i};
           }
           offsetMap.put(nums[i],i);

        }

        return null;
    }


    //https://leetcode.com/problems/add-two-numbers/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int singleSum = l1.val + l2.val;

        //record if it needs carry over
        int carryOver = checkOverflow(singleSum);
        ListNode resultHead = new ListNode(singleSum % 10);
        ListNode resultCurr = resultHead;


        ListNode node1 = l1.next;
        ListNode node2 = l2.next;

        while (node1 != null || node2 != null || carryOver !=0){

            int val1 = 0;
            int val2 = 0;

            if (node1 != null){
                val1 = node1.val;
                node1 = node1.next;
            }

            if (node2 != null){
                val2= node2.val;
                node2 = node2.next;
            }

            singleSum = val1 + val2 + carryOver;

            resultCurr.next = new ListNode(singleSum % 10);
            resultCurr = resultCurr.next;

            carryOver = checkOverflow(singleSum);


        }

        return resultHead;

    }

    static int checkOverflow(int number){
        if (number > 9){
            return 1;
        }
        return  0;
    }


}
