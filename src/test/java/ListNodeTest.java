import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ListNodeTest {
    @Test
    public void test_fast_array_to_list1node(){
        ListNode test = ListNode.fast_array_to_Listnode(new int[]{
                2,4,3
        });

        Assert.assertEquals(2,test.val);
        Assert.assertEquals(4,test.next.val);
        Assert.assertEquals(3,test.next.next.val);

    }

}