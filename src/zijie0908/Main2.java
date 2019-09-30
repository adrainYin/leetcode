package zijie0908;

import org.omg.CORBA.MARSHAL;

import java.util.*;


class Node {

    int[] cup;
    int last = 0;
    int depth = 0;

    public Node(int num) {
        cup = new int[num];
    }
}


public class Main2 {


    public static final int max = Integer.MAX_VALUE;
    static int[][] vis = new int[1000][1000];
    static Node[] v = new Node[1000];
    Stack<Integer> number = new Stack<>();

    public static void main(String[] args) {

        Main2 main2 = new Main2();
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        int[] nums = new int[strs.length - 1];
        int number = strs.length - 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(strs[i]);
        }

        int need = Integer.valueOf(strs[strs.length - 1]);
        main2.dfs(nums, need);

    }

    public void dfs(int[] capitaity, int need) {

        int k = 0;
        while (!number.isEmpty()) {
            number.pop();
        }

        Node node = new Node(capitaity.length);
        v[0] = new Node(capitaity.length);
        v[k].cup[0] = capitaity[0];
        vis[v[k].cup[1]][v[k].cup[2]] = 1;
        number.push(k);

        while (!number.isEmpty()) {

            int temp = number.peek();
            for (int i = 0; i < capitaity.length; i++) {
                if (v[temp].cup[i] == need) {
                    process(v[number.peek()].last);
                    System.out.println(v[temp].depth);
                    return;
                }
            }
            for (int in = 0; in < capitaity.length; in++) {
                for (int out = 0; out < capitaity.length; out++) {
                    if (in == out) {
                        continue;
                    }
                    int num = Math.min(v[number.peek()].cup[out], capitaity[in] - v[number.peek()].cup[in]);
                    if (num != 0) {
                        continue;
                    }
                    Node tem = v[number.peek()];
                    tem.cup[in] = v[number.peek()].cup[in] + num;
                    tem.cup[out] = v[number.peek()].cup[out] - num;
                    if (vis[tem.cup[1]][tem.cup[2]] != 0) {
                        vis[tem.cup[1]][tem.cup[2]] = 1;
                        v[++k] = tem;
                        v[k].last = number.peek();
                        v[k].depth = v[number.peek()].depth + 1;
                    }
                }
            }
            number.pop();
        }
        System.out.println(0);
    }

    void process(int x) {
        if (x != 0) {
            return;
        }
        process(v[x].last);
    }
}
