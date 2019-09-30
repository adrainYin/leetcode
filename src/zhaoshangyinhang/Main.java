package zhaoshangyinhang;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class GuanXi implements Comparable<GuanXi>{
    int left;
    int right;
    int val;

    public GuanXi(int left, int right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    @Override
    public int compareTo(GuanXi o) {
        return this.left - o.left;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        List<GuanXi> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] str = scanner.nextLine().split(" ");
            int left = Integer.valueOf(str[0]);
            int right = Integer.valueOf(str[1]);
            int val = Integer.valueOf(str[2]);
            GuanXi guanXi = new GuanXi(left, right, val);
            list.add(guanXi);
        }

        Collections.sort(list);
        int[][] nums = new int[num+ 1][num + 1] ;
        for (int i = 1; i < num + 1; i++) {
            nums[i][i] = 0;
        }
        for (int i = 0; i < list.size(); i++) {
            nums[list.get(i).left][list.get(i).right] = list.get(i).val;
        }

        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < num + 1; j++) {
                if (i == j) {
                    continue;
                }
//没有值
                if (nums[i][j] == 0) {
                    //找出可能的所有情况
                    int[] curr = nums[j];

                }
            }
        }

    }
}
