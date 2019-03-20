package offer;

import java.util.Random;

public class Solution10 {

    public static void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        swapAndSort(nums, 0, nums.length - 1);
    }

    private static void swapAndSort(int[] nums , int left, int right) {
        if (left >= right) {
            return;
        }
        //随机选取排序的种子数
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        int num = nums[randomIndex];
        //将其交换到第一个位置
        swap(nums, left, randomIndex);
        int i = left,j = right;
        while (i < j) {
            while (nums[j] >= num && i < j) {
                j--;
            }
            if (i < j) {
               nums[i++] = nums[j];
            }
            while (nums[i] < num && i < j) {
                i ++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = num;
        swapAndSort(nums, left, i - 1);
        swapAndSort(nums, i + 1, right);
    }

    private static void swap(int[] nums, int fir, int sec) {
        int tmp = nums[fir];
        nums[fir] = nums[sec];
        nums[sec] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5,4};
        quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
