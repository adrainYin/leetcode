package jingdong;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = Integer.valueOf(scanner.nextLine());
        String[] strs = new String[nums];
        for (int i = 0; i < nums; i++) {
            strs[i] = scanner.nextLine();
        }
        String pattern = scanner.nextLine();
        //最大的数量
//        int[] max = new int[pattern.length() + 1];
        //总是记录最大的
//        for (int i = 1; i < max.length; i++) {
//            int currMax = max[i];
//            for (int j = 0; j < num; j++) {
//                int currLength = strs[j].length();
//                //放不下该字符串
//                if (currLength > i) {
//                    continue;
//                }
//                else {
//                    //如果相等
//                    if (strs[j].equals(pattern.substring(i - currLength, i))) {
//                        currMax = Math.max(currMax, max[i - currLength] + 1);
//                    }
//                }
//            }
//            if (currMax == 0) {
//                max[i] = max[i - 1];
//            }
//            else {
//                max[i] = currMax;
//            }
//        }
        int num = 0;
        for (int i = 0; i < pattern.length();) {
            int max = 100000;
            for (int j = 0; j < nums; j++) {
                int len = strs[j].length();
                if (pattern.substring(i, len) == strs[j]) {
                    if (len < max) {
                        max = strs[j].length();
                    }
                    if (max != 100000) {
                        i = i + max;
                        num ++;
                    } else {
                        i++;
                    }
                }
            }

        }
        System.out.println(num);
//        System.out.println(max[max.length - 1]);
    }
}

