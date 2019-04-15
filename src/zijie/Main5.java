package zijie;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < nums; i++) {
            int number = Integer.valueOf(scanner.nextLine());
            String[] strings = scanner.nextLine().split(" ");
            int[] a = new int[number];
            //过河时间
            for (int j = 0; j < strings.length; j++) {
                a[j] = Integer.valueOf(strings[j]);
            }
            Arrays.sort(a);
            if (a.length == 2) {
                System.out.println(a[1]);
                continue;
            }
            if (a.length == 3) {
                System.out.println(a[2]);
                continue;
            }
            int minTime = a[1];
            int index = a.length - 1;
            int time = 0;
            int left = 2;
//            while (index > 2) {
//                time += a[index];
//                time += minTime;
//                index --;
//            }
//            for (int j = index; j > 2; j--) {
//                if (a[j] + )
//            }
            //这时候index == 2
            time += a[index];
            System.out.println(time);
        }
    }
}
