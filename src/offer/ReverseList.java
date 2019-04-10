package offer;


import java.util.List;

/**
 * 反转链表
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        //如果链表中只有一个结点则直接返回
        if (head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                newHead = node;
            }
            node.next = prev;
            prev = node;
            node = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        listNode1.next = null;
        ListNode result = reverseList(listNode1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
