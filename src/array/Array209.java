package array;

import java.util.*;

public class Array209 {

    /**
     * 最笨的解法，遍历数组
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {

        if (nums.length == 0){
            return 0;
        }
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int curr_num = 0;
            int curr_length = 0;
            for (int j = i; j < nums.length; j++) {
                curr_num += nums[j];
                curr_length ++;
                if (curr_num >= s){
                     set.add(curr_length);
                    break;
                }
            }
            if (curr_num < s){
                break;
            }
        }
        return !set.isEmpty() ? ((TreeSet<Integer>) set).first() : 0;
    }

    public static int methodB(int[] nums, int s){
        
        Integer length = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s){
                length = findSmall(length, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }

    private static int findSmall(int a, int b){
        return a < b ? a : b;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(minSubArrayLen(3, nums));
    }
}
