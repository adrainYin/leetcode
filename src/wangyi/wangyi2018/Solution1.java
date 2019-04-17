package wangyi.wangyi2018;

import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split("");
        int[] num = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            num[i] = Integer.valueOf(strs[i]);
        }

        int left = 0;
        int right = 0;
        int max = -1;
        int curr = 0;
        while (right < num.length - 1) {
            if (num[right] != num[right + 1]) {
                curr ++;
                right ++;
            }
            else {
                max = Math.max(max, curr + 1);
                right ++;
                curr = 0;
            }
        }
        max = Math.max(max, curr + 1);
        System.out.println(max);
    }
}
