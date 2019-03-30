package leetcode;

public class Leetcode61 {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length ++;
            tmp = tmp.next;
        }
        int moveIndex = k % length;
        if (moveIndex == 0 ) {
            return head;
        }

        tmp = head;
        int idx = 1;
        while (idx <length - moveIndex) {
            idx ++;
            tmp = tmp.next;
        }
        ListNode tail = tmp;
        ListNode newHead = tmp.next;
        tmp = newHead;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = head;
        tail.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;

        System.out.println(rotateRight(listNode1, 2).val);

    }
}
