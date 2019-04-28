package zijietiaodong;

import java.util.*;

/**
 * 作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。
 * 为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次（注意这里手串是一个环形）。
 * 手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种颜色不符合要求。
 * 即询问有多少种颜色在任意连续m个串珠中出现了至少两次。
 *
 * 输入描述:
 * 第一行输入n，m，c三个数，用空格隔开。(1 <= n <= 10000, 1 <= m <= 1000, 1 <= c <= 50)
 * 接下来n行每行的第一个数num_i(0 <= num_i <= c)表示第i颗珠子有多少种颜色。
 * 接下来依次读入num_i个数字，每个数字x表示第i颗柱子上包含第x种颜色(1 <= x <= c)
 * 输出描述:
 * 一个非负整数，表示该手链上有多少种颜色不符需求。
 * 示例1
 *
 *
 * 输入
 * 5 2 3
 * 3 1 2 3
 * 0
 * 2 2 3
 * 1 2
 * 1 3
 *
 *
 * 输出
 * 2
 */
public class Solution4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();

        int result = 0;
        List<Set<Integer>> list = new ArrayList<>();
        //构造原始的数组
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < num; j++) {
                set.add(scanner.nextInt());
            }
            list.add(set);
        }

        for (int i = 1; i <= c; i++) {
            boolean flag = true;
            List<Integer> res = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (list.get(j).contains(i)) {
                    res.add(j);
                }
            }
            if (res.size() != 1) {
                for (int j = 1; j < res.size(); j++) {
                    if (res.get(j) - res.get(j - 1) < m) {
                        result ++;
                        flag = false;
                        break;
                    }
                }
                if (flag && res.get(0) + n - res.get(res.size() - 1) < m) {
                    result ++;
                }
            }
        }
        System.out.println(result);
    }
}
