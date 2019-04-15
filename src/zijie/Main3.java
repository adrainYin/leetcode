package zijie;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int nums = Integer.valueOf(scanner.nextLine());
        String[] strs = scanner.nextLine().split(" ");
        int[] num = new int[nums];
        for (int i = 0; i < nums; i++) {
            num[i] = Integer.valueOf(strs[i]);
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            int result = i;
            boolean flag = true;
            for (int j = 0; j < nums; j++) {
                if (result >num[j]) {
                    result += result - num[j];
                } else if (result < num[j]) {
                    result -= num[j] - result;
                }
                if (result < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(result);
                break;
            }
        }
    }
}
