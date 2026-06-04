
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        //Approach Recursive
        // //Base cond.
        // if(head==null || head.next == null) return head;    //empty or single return
        
        // //Hypothesis
        // ListNode newHead = reverseList(head.next);  //call to minimized list
        
        // //Induction
        // head.next.next = head;
        // head.next = null;

        // return newHead;


        //Approach: Loop
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(list);
        System.out.println(reverseList(list));
    }
}