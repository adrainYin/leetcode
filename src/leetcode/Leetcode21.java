package leetcode;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Leetcode21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        ListNode index1 = l1;
        ListNode index2 = l2;
        ListNode head = new ListNode(0);
        ListNode root = head;
        while (index1 != null && index2 != null){
            if (index1.val <= index2.val){
                head.next = index1;
                head = head.next;
                index1 = index1.next;
            } else {
                head.next = index2;
                head = head.next;
                index2 = index2.next;
            }
        }

        if (index1 == null) {
            head.next = index2;
        }else {
            head.next = index1;
        }
        return root.next;
    }
}
