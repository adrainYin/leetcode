package leetcode;

public class Leetcode25 {

   public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode index = root;
        ListNode left = root.next;
        ListNode right = root;
        for (int i = 0; i < k; i++) {
            if (right.next == null){
                return head;
            }
            right = right.next;
        }
        while (left != null && right != null){
            ListNode nextIndex = left;
            index.next = right;
            ListNode next = left.next;
            left.next = right.next;
            while (next != right){
                ListNode nextNext = next.next;
                next.next = left;
                left = next;
                next = nextNext;
            }
            ListNode nextBegin = next.next;
            next.next = left;
            left = nextBegin;
            if (left == null){
                return root.next;
            }
            right = nextIndex;
            for (int i = 0; i < k; i++) {
                if (right == null){
                    return root.next;
                }
                right = right.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        ListNode head = reverseKGroup(listNode1, 2);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
