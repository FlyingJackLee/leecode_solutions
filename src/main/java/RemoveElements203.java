import java.util.*;

/**
 * 2 * @Author: Zumin Li
 * 3 * @Date: 2022/3/4 11:36 AM
 * 4
 */
public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        //增加冗余方便删除第一个
        ListNode dummy = new ListNode(-1,head);

        ListNode curr = dummy;
        while (curr != null && curr.next !=null){
            //如果下一个节点的值等于val
            if (curr.next.val == val){
                //删除下一个节点
                //如果存在下下个
                if (curr.next.next != null){
                    curr.next = curr.next.next;

                }
                //如果不存在设置为null
                else{
                    curr.next = null;
                }
            }

            //循环到下一个节点
            curr = curr.next;
        }

        ListNode ans = dummy.next;
        return ans;
    }


}
