package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode7 {
    public  static int reverse(int x) {

        boolean isNegative = x < 0 ? true : false;
        int temp = Math.abs(x);
        List<Integer> list = new ArrayList<>();
        while (temp > 0){
            int a = temp % 10;
            temp = temp / 10;
            list.add(a);
        }
        long reverseInteger = 0;
        if (isNegative == false) {
            for (int i = list.size() - 1; i >= 0; i--) {
                reverseInteger += list.get(i) * (long)Math.pow(10, list.size() - 1 - i);
                if (reverseInteger > Integer.MAX_VALUE) {
                    return 0;
                }
            }
            return (int)reverseInteger;
        }
        else {
            for (int i = list.size() - 1; i >= 0 ; i--) {
                reverseInteger += list.get(i) * (long)Math.pow(10, list.size() - 1 - i);
                if (0 - reverseInteger < Integer.MIN_VALUE){
                    return 0;
                }
            }
            return (int) (0 - reverseInteger);
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(-2147483648));

    }

}
