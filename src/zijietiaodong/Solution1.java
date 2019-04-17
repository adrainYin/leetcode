package zijietiaodong;

import java.util.Scanner;

public class Solution1 {

//    /**
//     * 暴力解法
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] p = new int[n + 1];
//        long[] count = new long[n + 2];
//        for (int i = 0; i < n; i++) {
//            p[i + 1] = scanner.nextInt();
//        }
//        int i = 1;
//        long step = 0;
//        count[1] = 1;
//        while (i != n + 1) {
//            //当前访问偶数次
//            if (count[i] % 2 == 0) {
//                i = i + 1;
//                count[i] += 1;
//            } else {
//                i = p[i];
//                count[i] += 1;
//            }
//            step += 1;
//        }
//        System.out.println(step % 1000000007);
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n + 1];
        long[] dp = new long[n + 2];
        for (int i = 0; i < n; i++) {
            p[i + 1] = scanner.nextInt();
        }
        //当走到奇数门的时候需要向回走一步，所以多了一个+1
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (2 * dp[i - 1] % 1000000007 - dp[p[i - 1]] + 2) % 1000000007;
        }
        System.out.println(dp[n + 1]);
    }
}
