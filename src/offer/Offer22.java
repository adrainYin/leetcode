package offer;

import java.util.List;

/**
 * 链表的倒数第k的结点
 */
public class Offer22 {


    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode emptyNode = new ListNode(-1);
        emptyNode.next = head;
        ListNode left = emptyNode;
        ListNode right = emptyNode;
        for (int i = 1; i <= k; i++) {
            right = right.next;
            //表示倒数的结点大于了链表的长度，应该直接返回null
            if (right == null) {
                return null;
            }
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        return left;
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
        ListNode result = FindKthToTail(listNode1, 6);
        System.out.println(result.val);
    }
}
