package leetcode;

public class Leetcode92 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (m >= n) {
            return head;
        }
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode node = head;
        ListNode pre = dumpy;
        if (m == 0) {
            m = 1;
        }
        int i = 1;
        while (node != null && i < m) {
            i += 1;
            pre = node;
            node = node.next;
        }
        //如果链表长度小于m，则不用翻转
        if (node == null) {
            return head;
        }
        ListNode tmp = pre;
        ListNode begin = node;
        pre = null;
        i = 0;
        while (node != null && i <= n - m) {
            ListNode next = node.next;
            //表示是最后的结点但是没有到为结点
            if (next == null && i < n - m) {
                tmp.next = node;
                begin.next = null;
            }
            //此时next是最后的结点
            else if (i == n - m - 1 && node == begin) {
                tmp.next = next;
                begin.next = next.next;
                next.next = node;
                break;
            } else if (i == n - m - 1) {
                tmp.next = next;
                begin.next = next.next;

            }
            node.next = pre;
            pre = node;
            node = next;
            i += 1;
        }
        return dumpy.next;
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
        ListNode head = reverseBetween(listNode1, 2, 4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
