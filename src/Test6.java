//
//class Node {
//    int val;
//    Node left;
//    Node right;
//
//    public Node(int val) {
//        this.val = val;
//    }
//}
//
//public class Test6 {
//
//    public static void main(String[] args) {
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//        Node node6 = new Node(6);
//        Node node7 = new Node(7);
//        Node node8 = new Node(8);
//        Node node9 = new Node(9);
//        Node node10 = new Node(10);
//        node1.left = node2;
//        node1.right = node2;
//        node2.left = node4;
//        node2.right = node5;
//        node3.right = node6;
//        node4.left = node7;
//        node4.right = node9;
//
//    }
//
//    private static Node getLowestAncestor(Node head, Node n1, Node n2) {
//        if (head == null || head == n1 || head == n2) {
//            return head;
//        }
//
//        Node left = getLowestAncestor(head.left, n1, n2);
//        Node right = getLowestAncestor(head.right, n1, n2);
//
//        if (left != null) {
//            return left;
//        }
//        if (right != null) {
//            return right;
//        }
//
//        return null;
//    }
//}
