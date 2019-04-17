package zijietiaodong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String str = scanner.next();
        int max = Math.max(getMaxLangth(n, m, str, 'a'), getMaxLangth(n, m, str, 'b'));
        System.out.println(max);

    }

    private static int getMaxLangth(int n, int m, String str, char c) {
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != c) {
                list.add(i);
            }
        }
        //全部变换
        if (list.size() <= m) {
            return str.length();
        }
        list.add(str.length());
        //开始遍历的第一个不同字符的位置
        //定义初始的长度
        max = list.get(m);
        for (int i = m + 1; i < list.size(); i++) {
            max = Math.max(max, list.get(i) - list.get(i - m  - 1) - 1);
        }
        return max;
    }
}
