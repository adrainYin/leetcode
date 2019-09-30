package zhaoshangyinhang;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int num = str.length();
        int[] length = new int[num];

        for (int i = 0; i < num; i++) {

            int yidoing = 0;
            int j = 0;
            char c = str.charAt(i);

            if (c == 'R') {
                j = i + 1;


                while (str.charAt(j) == c) {
                    yidoing++;
                    j++;
                }
                if ((yidoing & 1) == 1) {
                    length[j]++;
                } else {
                    length[j - 1]++;
                }
            } else if (c == 'L') {
                j = i - 1;
                while (str.charAt(j) == c) {
                    yidoing ++;
                    j --;
                }
                if ((yidoing & 1) == 1) {
                    length[j] ++;
                } else {
                    length[j + 1] ++;
                }
            }

        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < num; i++) {
            stringBuffer.append(length[i]).append(" ");
        }
        System.out.println(stringBuffer.substring(0, stringBuffer.length() - 1));


    }
}
