package leetcode;
import java.util.Arrays;

public class Leetcode16 {

    /**
     * O(n2)的复杂度。先排序，再计算绝对值
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int final_a = 0;
        int final_b = 0;
        int final_c = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                if (Math.abs(a + nums[left] + nums[right] - target) < min){
                    min = Math.abs(a + nums[left] + nums[right] - target);
                    final_a = i;
                    final_b = left;
                    final_c = right;
                }
                if (a + nums[left] + nums[right] > target){
                    right --;
                }
                else if (a + nums[left] + nums[right] < target){
                    left ++;
                }
                else {
                    break;
                }
            }
        }
        return nums[final_a] + nums[final_b] + nums[final_c];
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-1,0,4};
        System.out.println(threeSumClosest(nums,0));
    }
}
