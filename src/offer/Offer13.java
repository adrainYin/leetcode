package offer;

import java.util.HashMap;
import java.util.Map;

public class Offer13 {



public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}


    public RandomListNode Clone(RandomListNode pHead) {

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = pHead;
        //保存原先位置
        while (curr != null) {
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }

        curr = pHead;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(pHead);

    }
}
