 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

       public static ListNode fast_array_to_Listnode(int[] array){
            ListNode obj = new ListNode(array[0]);
            ListNode next = null;
            for (int i = 1; i < array.length; i++) {
                   if (next == null){
                         next = new ListNode(array[i]);
                         obj.next = next;
                   }
                   else {
                         next.next = new ListNode(array[i]);
                   }
             }

            return obj;
       }

  }
