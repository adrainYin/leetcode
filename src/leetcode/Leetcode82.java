package leetcode;


/**
 * 删除链表中的重复结点
 */
public class Leetcode82 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode empty = new ListNode(-1);
        empty.next = head;
        head = empty;
        ListNode node = head;
        while (node.next != null) {
            ListNode left = node.next;
            ListNode right = node.next;
            while (right.next != null && right.next.val == left.val) {
                right = right.next;
            }
            //代表right没有移动，可能到达了末尾或者没有重复的数字，这时候都要移动node的位置
            if (left == right) {
                //直接移动
                node = node.next;
            }
            //发生了移动，那么必定有重复的元素，无论停止条件是到达null还是不一样的值
            //这时候只是将node的next指针移动，而不移动node
            else {
                node.next = right.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        ListNode result = deleteDuplicates(listNode1);
        while ( result!= null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
