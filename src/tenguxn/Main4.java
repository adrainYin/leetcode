package tenguxn;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        int sum = 0;
        int lunshu = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        Arrays.sort(nums);

        while (sum >= 0 && lunshu < k) {
            if (sum == 0) {
                System.out.println(0);
                lunshu ++;
                continue;
            }
            int curr = -1;
            int index = -1;
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    curr = nums[i];
                    index = i;
                    System.out.println(curr);
                    break;
                }
            }
            for (int i = index; i < n; i++) {
                nums[i] -= curr;
            }
            sum -= (n - index) * curr;
            lunshu ++;

        }

    }


}
