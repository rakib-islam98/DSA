public class MaximumTwinSum {
    public static int pairSum(ListNode head) {
        int maxSum = Integer.MIN_VALUE;

        //Using array

        // ArrayList<Integer> list = new ArrayList<>();
        // ListNode curr = head;
        // while(curr != null) {
        //     list.add(curr.val);
        //     curr = curr.next;
        // }
        
        // int l = 0;
        // int h = list.size() - 1;
        // while(l < h) {
        //     maxSum = Math.max(maxSum, list.get(l) + list.get(h));
        //     l++;
        //     h--;
        // }

        //Using Stack

        // Stack<Integer> stack = new Stack<>();
        // ListNode slow = head; 
        // ListNode fast = head;
        // while(fast != null && fast.next != null) {
        //     stack.add(slow.val);
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // while(!stack.isEmpty()) {
        //     maxSum = Math.max(maxSum, slow.val + stack.pop());
        //     slow = slow.next;
        // }


        // List Reversal approach(2nd half)

        // ListNode slow = head, fast = head;
        // while(fast != null && fast.next != null) {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // ListNode prev = null, curr = slow;
        // while(curr != null) {
        //     ListNode next = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = next;
        // }
        // slow = prev;
        // ListNode slow2 = head;
        // while(slow != null) {
        //     maxSum = Math.max(maxSum, slow2.val + slow.val);
        //     slow = slow.next;
        //     slow2 = slow2.next;
        // }


        //List Reversal Approach (1st half) ~~no need 2nd pointer

        ListNode slow = head, fast = head, prev = null; //slow and curr do same purpose
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            //reversal logic
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;    //slow moved by one while reversing
        }
        //prev new head of the reversed 1st half
        while(slow != null) {
            maxSum = Math.max(maxSum, prev.val + slow.val);
            prev = prev.next;
            slow = slow.next;
        }

        return maxSum;
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(3))));
        System.out.println(pairSum(list1));
    }
}