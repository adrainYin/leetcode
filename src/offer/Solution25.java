package offer;

public class Solution25 {


    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        //定义哑结点
        ListNode begin = new ListNode(-1);
        begin.next = null;
        ListNode index = begin;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                ListNode tmp = head1;
                head1 = head1.next;
                index.next = tmp;
                index = index.next;
            } else {
                ListNode tmp = head2;
                head2 = head2.next;
                index.next = tmp;
                index = index.next;
            }
        }

        //第一个链表已经排好序
        if (head1 == null) {
         index.next = head2;
        } else if (head2 == null) {
            index.next = head1;
        }

        return begin.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = null;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        ListNode begin = merge(listNode1, listNode3);
        while (begin != null) {
            System.out.println(begin.val);
            begin = begin.next;
        }
    }
}
