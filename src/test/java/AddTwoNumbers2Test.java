import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbers2Test {

    @Test
    public void test_example_on_leecode(){
        ListNode l1 = ListNode.fast_array_to_Listnode(new int[]{2,4,3});
        ListNode l2 = ListNode.fast_array_to_Listnode(new int[]{5,6,4});

        ListNode result = AddTwoNumbers2.addTwoNumbers(l1,l2);

        Assert.assertEquals(7,result.val);
        Assert.assertEquals(0,result.next.val);
        Assert.assertEquals(8,result.next.val);


    }

}