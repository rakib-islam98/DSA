public class MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Approach: Recursion
        // if(list1==null) return list2;
        // if(list2==null) return list1;

        // if(list1.val<=list2.val) {
        //     list1.next=mergeTwoLists(list1.next,list2);
        //     return list1;
        // }
        // else {
        //     list2.next=mergeTwoLists(list1,list2.next);
        //     return list2;
        // }


        //Approach: Loop
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(list1 != null && list2!= null) {
            if(list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        //compare rest
        if(list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        System.out.println(list1);
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(list2);
        System.out.println(mergeTwoLists(list1, list2));
    }
}