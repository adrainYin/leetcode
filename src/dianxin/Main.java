package dianxin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = nums[0];
        for (int i = 1; i < k; i++) {
            result = result ^ nums[i];
        }
        System.out.println(result);
    }
}
