package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode23 {

    public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    }

    /**
     * 用优先队列解决
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result_index = new ListNode(0);
        result_index.next = null;
        ListNode root = result_index;
        //自定义比较器
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return  o1.val - o2.val;
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue(comparator);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null){
                queue.add(lists[i]);
            }
        }
        while (!queue.isEmpty()){
            ListNode currNode = queue.poll();
            result_index.next = currNode;
            result_index = currNode;

            if (currNode.next != null){
                queue.add(currNode.next);
            }
        }

        return root.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(10);
        ListNode listNode3 = new ListNode(3);
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue(comparator);
        queue.offer(listNode1);
        queue.offer(listNode2);
        queue.offer(listNode3);
        System.out.println(queue.peek().val);


    }
}
