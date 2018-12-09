package list;

import java.util.List;

public class List2 {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = listNode;

        int add = 0;
        while (p != null || q != null){
            int val1 = p == null ? 0 : p.val;
            int val2 = q == null ? 0 : q.val;

            int a = (val1 + val2 + add) % 10;
            ListNode node = new ListNode(a);
            add = (val1 + val2 + add) / 10;
            curr.next = node;
            curr = node;

            p = p!= null ? p.next : null;
            q = q!= null? q.next : null;
        }

        if (add > 0){
            ListNode finalNode = new ListNode(add);
            curr.next = finalNode;
            curr = finalNode;
        }

        return listNode.next;

    }
}
