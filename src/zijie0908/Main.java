package zijie0908;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, 0);
        }

        for (int i = nums.length - 1; i > 0 ; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= nums[i]) {
                    map.put(j, map.get(j) + 1);
                    break;
                }
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(i);
        }
        int index = n;
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (result[i] > max) {
                max = result[i];
                index = i;
            }
        }
        if (max == 0) {
            System.out.println(0);
            return;
        }
        else {
            System.out.println(nums[index]);
        }



    }
}
