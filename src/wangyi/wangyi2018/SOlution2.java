package wangyi.wangyi2018;

import java.util.Scanner;

public class SOlution2 {

    /**
     * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
     * 1、将a_i放入b序列的末尾
     * 2、逆置b序列
     * 小易需要你计算输出操作n次之后的b序列。
     *
     *
     * 4
     * 1 2 3 4
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            nums[i] = scanner.nextInt();
        }
        StringBuffer sb = new StringBuffer();
        //先从偶数的位置排序
        if (num % 2 == 0) {
            for (int i = num; i >=2 ; i -= 2) {
                sb.append(nums[i]).append(" ");
            }
            for (int i = 1; i <= num - 1; i += 2) {
                sb.append(nums[i]).append(" ");
            }
        } else {
            for (int i = num; i >= 1 ; i-= 2) {
                sb.append(nums[i]).append(" ");
            }
            for (int i = 2; i <= num - 1; i += 2) {
                sb.append(nums[i]).append(" ");
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
