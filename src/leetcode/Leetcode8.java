package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode8 {

    public static int myAtoi(String str) {
        String string = str.trim();
        if (string.length() == 0 || string == null){
            return 0;
        }
        char[] chars = string.toCharArray();
        if ((chars[0] != '+' &&chars[0] != '-' )&& ((chars[0] - '0') < 0 || (chars[0] - '9') > 0)){
            return 0;
        }
        long result = 0;
        List<Integer> list = new ArrayList<>();
        int isNegative = chars[0] == '-' ? -1 : 1;
        int index = (chars[0] =='+' || chars[0] == '-') ? 1 : 0;

        while (index < chars.length && chars[index] - '0' >=0 && chars[index] - '9' <= 0){
            list.add(chars[index] - '0');
            index ++ ;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            result += list.get(i) * Math.pow(10, list.size() - 1 - i);
        }
        result = result * isNegative;
        if (result> Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(myAtoi(" "));
    }
}
