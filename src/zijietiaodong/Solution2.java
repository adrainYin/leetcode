package zijietiaodong;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String[] strings = scanner.nextLine().split(" ");
            long n = Long.valueOf(strings[0]);
            long k = Long.valueOf(strings[1]);
            long d1 = Long.valueOf(strings[2]);
            long d2 = Long.valueOf(strings[3]);

            boolean flag = canSloution(n, k, d1, d2);
            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean canSloution(long n, long k, long d1, long d2) {
        if (n % 3 != 0) {
            return false;
        }
        long tmp = n / 3;
        return doSolution(n, k, -d1, d2, tmp) || doSolution(n, k, d1, -d2, tmp) ||
                doSolution(n, k, -d1, -d2, tmp) || doSolution(n, k, d1, d2, tmp);
    }

    private static boolean doSolution(long n, long k, long d1, long d2, long temp) {
        if ((k - d1 - d2) % 3 != 0) {
            return false;
        }
        long s2 = (k - d1 - d2) / 3;
        long s1 = s2 + d1;
        long s3 = s2 + d2;
        if (s2 > temp || s1 > temp || s3 > temp || s2 < 0 || s1 < 0 || s3 < 0) {
            return false;
        }
        return true;
    }
}
