package leetcode;

public class Leetcode24 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode index = root;
        while(index.next != null && index.next.next != null) {
            ListNode left = index.next;
            ListNode right = index.next.next;
            left.next = right.next;
            right.next = left;
            index.next = right;
            index = index.next.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next =null;

         ListNode root = swapPairs(listNode1);
         while (root != null){
             System.out.println(root.val);
             root = root.next;
         }
    }
}
