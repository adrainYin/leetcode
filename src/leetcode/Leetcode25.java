package leetcode;

public class Leetcode25 {

   public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    /**
     * 方法不对，应该参考三种链表反转的方法。
     * @param head
     * @param k
     * @return
     */
   public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode index = root;
        ListNode left = root.next;
        ListNode right = root;
        for (int i = 0; i < k; i++) {
            if (right.next == null){
                return head;
            }
            right = right.next;
        }
        while (left != null && right != null){
            ListNode nextIndex = left;
            index.next = right;
            ListNode next = left.next;
            left.next = right.next;
            while (next != right){
                ListNode nextNext = next.next;
                next.next = left;
                left = next;
                next = nextNext;
            }
            ListNode nextBegin = next.next;
            next.next = left;
            left = nextBegin;
            if (left == null){
                return root.next;
            }
            right = nextIndex;
            for (int i = 0; i < k; i++) {
                if (right == null){
                    return root.next;
                }
                right = right.next;
            }
        }
        return root.next;
    }

    /**
     * 反转链表的操作，一定要记住
     * @param head
     * @param k
     * @return
     */
    public static ListNode solution(ListNode head, int k) {
       if (head == null){
           return null;
       }
       ListNode root = new ListNode(0);
       root.next = head;
       ListNode startNode = root;
       ListNode temp = head;
       //记录链表的总长度
       int n = 0;
       while (temp != null){
           n ++;
           temp = temp.next;
       }
       while (n >= k){
           for (int i = 0; i < k-1; i++) {
                ListNode node = root.next;
                root.next = head.next;
                head.next = root.next.next;
                root.next.next = node;
           }
           root = head;
           head = head.next;
           n -= k;
       }
       return startNode.next;
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
        listNode5.next = listNode6;
        listNode6.next = null;
        ListNode head = solution(listNode1, 3);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
