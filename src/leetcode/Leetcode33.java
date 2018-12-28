package leetcode;

public class Leetcode33 {

    /**
     * 二分查找树的变形,通过判断中间元素在旋转数组中的位置来确定查找的顺序，时间复杂度O(logn)
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else
                return -1;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            if (nums[mid] < nums[left]) {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    if (nums[left] < target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            } else {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    if (nums[left] < target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
       int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 2));
    }
}
