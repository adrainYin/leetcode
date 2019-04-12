package wangyi;


import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.valueOf(strings[i]);
        }

        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = Integer.MAX_VALUE;
        int e = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nums[i] > a) {
                    c = b;
                    b = a;
                    a = nums[i];
                } else if (nums[i] > b) {
                    c = b;
                    b = nums[i];
                } else if (nums[i] > c) {
                    c = nums[i];
                } else if (nums[i] < e) {
                    d = e;
                    e = nums[i];
                } else if (nums[i] > e && nums[i] < d) {
                    d = nums[i];
                }
            }
        }
        System.out.println(Math.max(a * b * c, a * d * e));
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "hello");

    }

}
