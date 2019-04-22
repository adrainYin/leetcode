package wangyi.wangyi2018;




import java.util.Scanner;

/**
 * 题目描述
 * 对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
 * 牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
 * 输入描述:
 * 输入包括一行,一行中有4个正整数x1, k1, x2, k2(1 ≤ x1,x2 ≤ 10^9, 1 ≤ k1,k2 ≤ 50),以空格分割
 * 输出描述:
 * 如果v1小于v2输出"Less",v1等于v2输出"Equal",v1大于v2输出"Greater".
 *
 *
 * 示例1
 * 输入
 * 1010 3 101010 2
 * 输出
 * Equal
 */
public class Solution7 {

    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        int x1 = scanner.nextInt();
        int k1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int k2 = scanner.nextInt();

        StringBuilder sb1 = new StringBuilder();
        for (int i = 1; i <= k1; i++) {
            sb1.append(x1);
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = 1; i <= k2; i++) {
            sb2.append(x2);
        }

        System.out.println(jundge(sb1.toString(), sb2.toString()));
    }

    private static String jundge(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return "Less";
        }
        else if (str1.length() > str2.length()) {
            return "Greater";
        }
        else {
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            for (int i = 0; i < str1.length(); i++) {
                if (chars1[i] - chars2[i] > 0) {
                    return "Greater";
                }
                else if (chars1[i] - chars2[i] < 0) {
                    return "Less";
                }
            }
            return "Equal";
        }
    }
}
