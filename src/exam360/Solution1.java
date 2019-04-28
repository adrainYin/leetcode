package exam360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 将一个字符串转换成一个整数，数值为0或者是字符串等不是一个合法的数值则返回0，小数直接取整数部分。要求：不能使用字符串转换整数的库函数
 *
 * 输入
 * 字符串
 *
 * 输出
 * 整数
 *
 *
 * 样例输入
 * 0360
 * 样例输出
 * 360
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        System.out.println(string2int(str));

    }

    static int string2int(String str) {

        String string = str;
        if (string == null || string.length() == 0) {
            return 0;
        }
        char[] chars = string.toCharArray();
        //初始不合法
//        if ((chars[0] != '+' && chars[0] != '-') && (chars[0] - '0') < 0 || (chars[0] - '9') > 0) {
//            return 0;
//        }
        if (( chars[0] != '-') && (chars[0] - '0') < 0 || (chars[0] - '9') > 0) {
            return 0;
        }
        int result = 0;
        List<Integer> list = new ArrayList<>();
        int isNegative = chars[0] == '-' ? -1 : 1;
//        int index = (chars[0] == '+' || chars[0] == '-') ? 1 : 0;
        int index = (chars[0] == '-') ? 1 : 0;

        while (index < chars.length && chars[index] - '0' >= 0 && chars[index] - '9' <= 0 && chars[index] != ' ') {
            list.add(chars[index] - '0');
            index ++;
        }
        //表示遇到了小数点，那么后面必须要有数字，并且不能有.
        if (index < chars.length && chars[index] == '.') {
            if (index == chars.length - 1) {
//                return 0;
                for (int i = list.size() - 1; i >= 0 ; i--) {
                    result += list.get(i) * Math.pow(10, list.size() - 1 - i);
                }
                result = result * isNegative;
                return (int) result;
            }
            index ++;
            while (index < chars.length && chars[index] - '0' >= 0 && chars[index] - '9' <= 0) {
                index ++;
            }
            if (index < chars.length) {
                return 0;
            }
            else {
                for (int i = list.size() - 1; i >= 0 ; i--) {
                    result += list.get(i) * Math.pow(10, list.size() - 1 - i);
                }
                result = result * isNegative;
            }
        }
        else if (index < chars.length && chars[index] != '.') {
            return 0;
        }
        else {
            for (int i = list.size() - 1; i >= 0 ; i--) {
                result += list.get(i) * Math.pow(10, list.size() - 1 - i);
            }
            result = result * isNegative;
        }
        return (int) result;
    }
}
