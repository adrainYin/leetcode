package wangyi.wangyi2018;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] x = new int[num];
        int[] y = new int[num];
        for (int i = 0; i < num; i++) {
            x[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            y[i] = scanner.nextInt();
        }
        List<Long> result = new ArrayList<>();
        result.add(0L);

        //定义
        for (int i = 2; i <= num; i++) {

        }
    }


    private static List<Long> getResult(int num, int[] x, int[] y) {
        List<Long> result = new ArrayList<>();
        PriorityQueue queue = new PriorityQueue();
        return result;
    }
}
