import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 携程笔试专用main函数
 */



class Node {
    String val;
    Node next;

    public Node(String val) {
        this.val = val;
    }
}

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = null;
        if (scanner.hasNextLine()) {
            strs = scanner.nextLine().split(",");
        }
        if (strs.length == 0) {
            System.out.println(false);
        }
        //构造链表
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            nodeList.add(new Node(strs[i]));
        }
        //给出头结点
        Node head = nodeList.get(0);
        //构造链表引用
        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).next = nodeList.get(i+1);
        }
        nodeList.get(nodeList.size() - 1).next = null;

        System.out.println(hasCircle(head));
    }


    /**
     * 使用快慢指针追赶法
     * 每次快指针移动2个单位，慢指针移动1个单位。如果有环，那么进入环之后快指针一定能赶上慢指针
     * 如果没有环，那么慢指针一定能到达尾结点,如果快指针的下一个为null，说明也到达了尾结点
     * @param head 头指针
     * @return 是否存在环
     */
    private static boolean hasCircle(Node head) {
        if (head == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val.equals(fast.val)) {
                return true;
            }
        }
        return false;
    }
}
