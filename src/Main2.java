import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strs = string.substring(1, string.length() - 1).split(",");
        int num = Integer.valueOf(scanner.nextLine());

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

        Node newHead = reverseByNum(head, num);
        Node index = newHead;
        List<String> list = new ArrayList<>();
        while (index != null) {
            list.add(index.val);
            index = index.next;
        }
//        System.out.println(list.toString());
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            sb.append(",");
        }
        String str = sb.toString().substring(0, sb.toString().length() - 1) + "]";
        System.out.println(str);
    }


    private static Node reverseByNum(Node head, int num) {
        if (head == null){
            return null;
        }
        Node root = new Node("");
        root.next = head;
        Node startNode = root;
        Node temp = head;
        //记录链表的总长度
        int n = 0;
        while (temp != null){
            n ++;
            temp = temp.next;
        }
        while (n >= num){
            for (int i = 0; i < num-1; i++) {
                Node node = root.next;
                root.next = head.next;
                head.next = root.next.next;
                root.next.next = node;
            }
            root = head;
            head = head.next;
            n -= num;
        }
        return startNode.next;
    }
}
