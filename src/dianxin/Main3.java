package dianxin;

import java.util.Scanner;

public class Main3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String sub = str.substring(1, str.length() - 1);
        String[] strs = sub.split(", ");
        int num = strs.length;
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = Integer.valueOf(strs[i]);
        }
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {

        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < nums.length; i++) {
            thisSum += nums[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            }
            else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
