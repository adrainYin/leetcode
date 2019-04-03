package leetcode;

public class Leetcode75 {

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        int[] temp = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                temp[left++] = 0;
            } else if (nums[i] == 2) {
                temp[right--] = 2;
            }
        }
        while (left <= right) {
            temp[left++] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
