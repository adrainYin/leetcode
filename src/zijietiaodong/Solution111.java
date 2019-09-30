package zijietiaodong;

import java.util.Scanner;

public class Solution111 {

    public static int findKthNumber(int m, int n, int k) {

        int low = 1, high = m * n + 1;
        k = m * n + 1 - k;
        int mid, count;
        while (low < high) {
            mid = low + (high - low) / 2;
            count = 0;
            for (int i = 1; i <= m; i++) {
                count += (mid/i > n ? n : mid/i);
            }
            if (count >= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(findKthNumber(m,n,k));
    }

}
