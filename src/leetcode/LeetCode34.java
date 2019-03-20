package leetcode;

public class LeetCode34 {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid]==target){
                while(mid>=left && nums[mid]==target){
                    mid--;
                }
                result[0] = mid+1;
                mid = (left + right)/2;
                while(mid<=right && nums[mid]==target){
                    mid++;
                }
                result[1] = mid - 1;
                break;
            }else if (nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,4,4,5,6,6,6,7};
        int[] result = searchRange(nums, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
