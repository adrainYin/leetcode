package leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;

public class Leetcode16 {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                min = Math.abs(nums[a] + nums[left] + nums[right] - target) < min ? Math.abs(nums[a] + nums[left] + nums[right] - target) : min;
                 left ++;
                 right --;
            }
        }

    }
}
