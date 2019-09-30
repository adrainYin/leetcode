package bilibli;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(totalSum(scanner.nextInt()));
    }


    public static int totalSum(int num) {

        //初始化总数
        int sum = 1;
        int target = num << 1;
        //定义初始的遍历数
        int initIndex = (int) Math.sqrt(target);

        for (int i = initIndex; i > 1; i--) {
            int temp = num - (i * (i - 1)) /2;
            if (temp % i == 0) {
                sum ++;
            }
        }
        return sum;
    }
}
