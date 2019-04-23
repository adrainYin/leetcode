package aiqiyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 如果一个整数只能被1和自己整除,就称这个数是素数。
 * 如果一个数正着反着都是一样,就称为这个数是回文数。例如:6, 66, 606, 6666
 * 如果一个数字既是素数也是回文数,就称这个数是回文素数
 * 牛牛现在给定一个区间[L, R],希望你能求出在这个区间内有多少个回文素数。
 * 输入描述:
 * 输入包括一行,一行中有两个整数(1 ≤ L ≤ R ≤ 1000)
 * 输出描述:
 * 输出一个整数,表示区间内回文素数个数。

 * 示例1
 * 输入

 * 100 150
 * 输出

 * 2
 */
public class Solution3 {

    /**
     * 使用区间的素数筛法
     * 注意1不是素数
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        if (R == 1) {
            System.out.println(0);
            return;
        }
        int length = R - L + 1;
        boolean[] isPrime = new boolean[length];
        boolean[] sqrtPrime = new boolean[(int)Math.sqrt(R) + 1];
        for (int i = 2; i <= Math.sqrt(R); i++) {
            if (sqrtPrime[i]) {
                continue;
            }
            for (int j = 2; j * i <= Math.sqrt(R); j++) {
                sqrtPrime[j * i] = true;
            }
            //得到最接近L的i的倍数
            for (int j = Math.max(2, (L + i - 1) / i) * i; j <= R; j += i) {
                isPrime[j - L] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (!isPrime[i] && isHuiwenshu(i + L) && i + L != 1) {
                count ++;
            }
        }
        System.out.println(count);
    }

    private static boolean isHuiwenshu(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length() / 2; i++) {
            if (!(str.charAt(i) == str.charAt(str.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

}
