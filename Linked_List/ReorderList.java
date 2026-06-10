public class ReorderList {
    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next; //starting of 2nd half
        slow.next = null;   //separate two halves

        //reversing 2nd half
        ListNode prev = null;
        while(second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        //Merge two halves
        ListNode first = head;
        second = prev;
        while(second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            second.next = first.next;
            first.next = second;
            first = temp1;
            second = temp2;
        }

        // ListNode slow = head;
        // ListNode fast = head;
        // while(fast != null && fast.next != null) {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // ListNode prev = null;
        // while(slow != null) {
        //     ListNode next = slow.next;
        //     slow.next = prev;
        //     prev = slow;
        //     slow = next;
        // }
        // ListNode head1 = head;
        // ListNode head2 = prev;
        // while(head2.next != null) {
        //     ListNode next1 = head1.next;
        //     ListNode next2 = head2.next;
        //     head2.next = head1.next;
        //     head1.next = head2;
        //     head1 = next1;
        //     head2 = next2;
        // }
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(list1);
        reorderList(list1);
        System.out.println(list1);
    }
}