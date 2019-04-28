package aiqiyi;

import java.util.HashSet;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuffer sb = new StringBuffer();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                sb.append(str.charAt(i));
                set.add(str.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
