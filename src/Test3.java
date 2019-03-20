import java.math.BigInteger;
import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs1 = scanner.nextLine().split(" ");
        String[] strs2 = scanner.nextLine().split(" ");

        int[] nums = new int[Integer.valueOf(strs1[1]) + 1];
        int left = 0;
        int right = 0;
        int min_length = -1;
        int temp = 0;
        while (temp < strs2.length) {
            while (count(nums) == 0) {
                nums[Integer.valueOf(strs2[temp])] ++;
                temp ++;
            }
        }
        if (temp == strs2.length) {
            System.out.println(-1);
            return;
        }

        min_length = temp + 1;
        while (right < strs2.length) {
            if (nums[Integer.valueOf(strs2[right])] == 0) {
                nums[Integer.valueOf(strs2[right])] ++;
                right ++;
                continue;
            } else {
                min_length = right - left;
                nums[Integer.valueOf(strs2[right])] ++;
            }

            while (nums[Integer.valueOf(left)] > 0) {
                nums[Integer.valueOf(left)] --;
                left++;

            }
        }
    }

    public static int count(int[] nums) {
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            temp *= nums[i];
        }
        return temp;
    }
}
