package leetcode;

public class Leetcode55 {

    public static boolean canJump(int[] nums) {
        return isDump(nums);
    }

    /**
     * dnf回溯方法，时间复杂度不够
     * @param nums
     * @param index
     * @return
     */
    public static boolean dfs(int[] nums, int index) {
        if (nums[index] + index >= nums.length - 1) {
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }

        for (int i = nums[index]; i > 0; i--) {
            if (dfs(nums, index + i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDump(int[] nums) {
        int currMax = nums[0];
        int i = 0;
        while (i <= nums.length - 1) {
            int temp = i;
            if (i + nums[i] >= nums.length - 1) {
                return true;
            }
            for (int j = 1; j <= currMax; j++) {
                if (i + j + nums[i + j] > i + currMax) {
                    currMax = nums[i + j];
                    i = i + j;
                    break;
                }
            }
            if (temp == i) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
