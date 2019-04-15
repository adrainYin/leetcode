package leetcode;

public class Leetcode86 {
    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        ListNode left = dumpy;
        ListNode index = dumpy;
        while (index.next != null && index.next.val < x) {
            index = index.next;
            left = index;
        }
        while (index.next != null) {
            if (index.next.val >= x) {
                index = index.next;
            } else {
                ListNode temp = index.next;
                index.next = temp.next;
                temp.next = left.next;
                left.next = temp;
                left = left.next;
            }
        }
        return dumpy.next;
    }
}
