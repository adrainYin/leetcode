package tenguxn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = Integer.valueOf(scanner.nextLine());
        int[] lengths = new int[nums];
        String[] phone = new String[nums];
        for (int i = 0; i < nums; i++) {
            lengths[i] = Integer.valueOf(scanner.nextLine());
            phone[i] = scanner.nextLine();
        }

        for (int i = 0; i < nums; i++) {
            solution(lengths[i], phone[i]);
        }
    }

    public static void solution(int length, String nums) {
        if (length <= 10 || (length == 11 && nums.charAt(0) - '0' != 8)) {
            System.out.println("NO");
            return;
        }


        boolean flag = false;

        for (int i = 0; i < length; i++) {
            if (nums.charAt(i) - '0' != 8) {
                continue;
            }
            if (length - i >= 11) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }


    }
}
