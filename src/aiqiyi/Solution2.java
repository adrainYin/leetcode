package aiqiyi;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = scanner.nextInt();
        }
        int count = 0;
        int result = 0;
        while (result < n && count + f[result] <= s) {
            count += f[result];
            result ++;
        }
        System.out.println(result);
    }
}
