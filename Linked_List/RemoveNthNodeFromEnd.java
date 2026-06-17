public class RemoveNthNodeFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // int size = 0;
        // ListNode curr = head;
        // while(curr != null) {
        //     curr = curr.next;
        //     size++;
        // }

        // int step = size - n - 1;
        // if (step < 0) {
        //     return head.next;   //negative step means delete head
        // }
        // curr = head;
        // while(step > 0) {
        //     curr = curr.next;
        //     step--;
        // }
        // curr.next = curr.next.next;
        // return head;

        // ListNode slow = head, fast = head;
        // for(int i = 0; i < n; i++) {
        //     fast = fast.next;
        // }
        // if(fast == null) return slow.next;
        // while(fast.next != null) {
        //     slow = slow.next;
        //     fast = fast.next;
        // }
        // slow.next = slow.next.next;
        // return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;
        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(list1);
        System.out.println(removeNthFromEnd(list1, 3));
    }
}