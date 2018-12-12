package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Leetcode9 {

    public static boolean isPalindrome(int x) {

        if (x < 0){
            return false;
        }
        if (x == 0){
            return true;
        }
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));

        List<Integer> list = new LinkedList<>();
    }
}
