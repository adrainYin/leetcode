package zijie0908;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        int n = Integer.valueOf(strs[0]);
        int m = Integer.valueOf(strs[1]);
        int q = Integer.valueOf(strs[2]);
        char[] chars =  new char[n];
        String string = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            chars[i] = string.charAt(i);
        }
        for (int i = 0; i < q; i++) {
            String[] strings = scanner.nextLine().split(" ");
            int o = Integer.valueOf(strings[0]);
            int p = Integer.valueOf(strings[1]);
            solution(chars, o, p);
        }
    }

    public static void solution(char[] chars, int left, int right) {
        int pos = left;
        int begin = left;
        int end = right;
        while (begin <= end && pos >= begin && pos <= end) {

        }
    }
}
