import java.util.Stack;

public class AddTwoNumbers2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> resultStack = new Stack<>();

        int pushOneToUpperDigital = 0;

        while (l1 != null || l2 != null) {
            int singleDigitalSum = pop_node_to_next(l1) + pop_node_to_next(l2) + pushOneToUpperDigital;

            if (singleDigitalSum >= 10) {
                singleDigitalSum = singleDigitalSum % 10;

                pushOneToUpperDigital = 1;

            } else {
                pushOneToUpperDigital = 0;
            }

            resultStack.push(singleDigitalSum);
        }

        ListNode result = new ListNode(resultStack.pop());
        ListNode next = null;

        while (!resultStack.empty()){
            if (next == null){
                next  = new ListNode(resultStack.pop());
                result.next = next;
            }
            else {
                next.next = new ListNode(resultStack.pop());
                next = next.next;
            }
        }

        return result;

    }

    private static int pop_node_to_next(ListNode node){
        if (node == null){
            return 0;
        }
        else {
            node.val = node.next.val;
            node.next = node.next.next;

            return node.val;
        }

    }
}
