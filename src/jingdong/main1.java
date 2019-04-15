package jingdong;

import java.util.*;

class  Node implements Comparable<Node> {
    int child;
    int parent;

    public Node(int fir, int sec) {
        this.child = fir;
        this.parent = sec;
    }


    @Override
    public int compareTo(Node o) {
        if (this.parent != o.parent) {
            return this.child - o.child;
        }
        return this.parent - o.parent;
    }
}

public class main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nums ; i++) {

        }
        Node node = new Node(scanner.nextInt(), scanner.nextInt());


        list.add(node);

        Collections.sort(list);
        System.out.println(list);
    }

}
