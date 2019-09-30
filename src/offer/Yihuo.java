package offer;

import java.util.Arrays;

public class Yihuo {

    public static int FirstNotRepeatingChar(String str) {

        int[] ascii = new  int[256];
        for (int i = 0; i < str.length(); i++) {
            ascii[str.charAt(i) - 'A'] ++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (ascii[(str.charAt(i) - 'A')] == 1) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,5,0};
        System.out.println(isContinuous(nums));
    }


    //大王小王的排序题
    public static boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int dawangxiaowang = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < 4; i++) {
            if (numbers[i] == 0) {
                dawangxiaowang ++;
            }
            else {
                break;
            }
        }
        for (int i = dawangxiaowang + 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i-1] ) {
                return false;
            }
            if ( numbers[i] - numbers[i-1] != 1 && numbers[i] - numbers[i-1] - 1 > dawangxiaowang) {
                return false;
            }
            if (numbers[i] - numbers[i-1] != 1) {
                dawangxiaowang -= numbers[i] - numbers[i-1] - 1;
            }
        }
        return true;

    }


    /**
     * 如果大于1则是高位数字加1乘以10(j - 1)
     * 如果高位数字小于1则是高位数字乘以10(j - 1)
     * 如果为1那么就是高位数字乘以10（j-1）加上地位数数字加1
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution(int n) {
        int num = 0;
        int beishu = 1;
        while (n != 0) {
            int temp = (int) (n % Math.pow(10, beishu));
            n = (int)(n / Math.pow(10, beishu));
            int high = (int)(n % Math.pow(10, beishu + 1));
            if (high > 1) {
                num += (n + 1) * Math.pow(10, beishu - 1);
            }

        }
        return 0;
    }
}
