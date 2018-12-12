package list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Leetcode19 {


    /**
     * hash函数存储节点，空间复杂度为O(n)
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        if (head == null){
            return null;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        int i = 1;
        while (root.next != null){
            map.put(i++, root.next);
            root = root.next;
        }
        int length = i - 1;
        if (n < 1 || n > length){
            return null;
        }
        if (n == length){
            return map.get(1).next;
        }
        if (n == 1){
            map.get(length - 1).next = null;
            return head;
        }
        map.get(length - n).next = map.get(length - n + 2);
        return head;
    }

    public static ListNode method(ListNode head, int n) {

        if (head == null){
            return null;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode left = root;
        ListNode right = root;

        for (int i = 1; i <= n + 1 ; i++) {
            right =  right.next;
        }

        while (right != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        System.out.println(removeNthFromEnd(listNode, 1));

    }
}
