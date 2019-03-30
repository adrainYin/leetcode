package offer;




class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution18 {

    public static ListNode deleteNode(ListNode head, ListNode node) {
        if (node == null || head == null) {
            return head;
        }
        ListNode listNode = head;
        if (node == head) {
            listNode = head.next;
            head.next = null;
            head = null;
            return listNode;
        }
        ListNode nextNode = node.next;
        //是尾结点,还是需要遍历找到前一个结点
        if (nextNode == null) {
            ListNode tmp = head;
            while (tmp.next != node) {
                tmp = tmp.next;
            }
            tmp.next = null;
        } else {
            node.val = node.next.val;
            node.next = nextNode.next;
        }
        return head;
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
        ListNode head = deleteNode(listNode1, listNode5);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
