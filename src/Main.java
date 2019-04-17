//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
///**
// * 在线笔试专用Main类
// * 请不要随意做修改
// */
//public class Main {
//
//
//    public static void main(String[] args) throws IOException {
//

//        Scanner scanner = new Scanner(System.in);
//        String[] strings = scanner.nextLine().split(" ");
//        int value = Integer.valueOf(strings[0]);
//        int num = Integer.valueOf(strings[1]);
//        int[] nums = new int[num];
//        for (int i = 0; i < num; i++) {
//            nums[i] = Integer.valueOf(scanner.nextLine());
//        }
//        //面值数组
//        Arrays.sort(nums);
//        int max_value = nums[nums.length - 1];
//        //维持最少的硬币数量
//        int[] need = new int[value + 1];
//        int index = num - 1;
//        int count = 0;
//        //初始化
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] <= need.length - 1) {
//                need[nums[i]] = 1;
//            }
//        }
//        for (int i = 1; i < need.length; i++) {
//            if (need[i] != 1) {
//                need[i] = Integer.MAX_VALUE;
//            }
//        }
//        for (int i = 1; i < need.length; i++) {
//            //需要填充
//            if (need[i] == 0) {
//                for (int j = nums.length - 1; j >= 0; j++) {
//                    int needMianzhi = nums[j];
//                    //可以使用
//                    if (i - needMianzhi >= 0) {
//                        //没有面额
//                        if (need[i - needMianzhi] < ){
//
//                        }
//                    }
//                }
//            }
//        }

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int wuli[] = new int[n];
//        int jinbi[] = new int[n];
//        for(int i =0;i<n;i++) {
//            wuli[i] = scanner.nextInt();
//        }
//        for(int i =0;i<n;i++) {
//            jinbi[i] = scanner.nextInt();
//        }
//        System.out.println(function(wuli, jinbi));
//    }
//}


/**
 * 腾讯笔试题目的第二道, 直接使用暴力法求解
 */
//    private static int function(int wuli[],int jinbi[]) {
//        if(wuli.length==1) {
//            return jinbi[0];
//        }
//        int sum1 = wuli[0];
//        int sum2 = jinbi[0];
//        for(int i = 1;i<wuli.length;i++) {
//            if(sum1>=wuli[i]) {
//                continue;
//            }else {
//                sum1+= wuli[i];
//                sum2+= jinbi[i];
//            }
//        }
//        return sum2;
//
//    }


/**
 * 腾讯笔试题目的第一道
 */

import java.util.Arrays;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int sum = 0,ans = 0;
        int num[] = new int[n];
        for(int i = 0;i<n;i++) {
            num[i] = scanner.nextInt();
        }
        Arrays.sort(num);
        if(num[0]!=1) {
            System.out.println("-1");
        }
        while(true) {
            if(sum >= m) {
                System.out.println(ans);
                break;
            }
            for(int i = n-1;i >= 0;i --) {
                if(num[i] <= sum + 1) {
                    sum += num[i];
                    ans++;
                    break;
                }
            }
        }
    }
}