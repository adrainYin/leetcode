package leetcode;

public class Leetcode35 {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length -1;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (right < 0){
            return 0;
        }
        if (nums[right] == target){
            return left;
        }
        else if (nums[right] < target){
            return right + 1;
        }
        else {
            return right;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(searchInsert(nums, 0));
    }
}
