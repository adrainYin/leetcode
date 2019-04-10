package leetcode;

public class Leetcode80 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int n : nums) {
            if (i < 2 || nums[i - 2] < n) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3};
        System.out.println(removeDuplicates(nums));
        for (int n : nums) {
            System.out.println(n);
        }
    }
}
