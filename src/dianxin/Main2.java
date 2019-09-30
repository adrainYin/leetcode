package dianxin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(";");

        String str1 = strs[0];
        String str2 = strs[1];

        if (str1 == null && str2 == null) {
            System.out.println("True");
            return;
        }
        if ((str1 == null && str2 != null) ||(str1 != null && str2 == null)) {
            System.out.println("False");
            return;
        }
        if (str1.length() != str2.length()) {
            System.out.println("False");
            return;
        }

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            map1.put(str1.charAt(i), str2.charAt(i));
        }
        for (int i = 0; i < str2.length(); i++) {
            map2.put(str2.charAt(i), str1.charAt(i));
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != map2.get(str2.charAt(i)) || str2.charAt(i) != map1.get(str1.charAt(i))) {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");

    }
}
