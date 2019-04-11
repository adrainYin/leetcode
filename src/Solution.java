public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,2,2,2};
        int result = solution(nums, 2);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }
    }

    private static int solution(int[] nums, int num) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;

//        int index = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != num) {
//                nums[index] = nums[i];
//                index ++;
//            }
//        }
//        return index;
//        int right = nums.length - 1;
        while (right < nums.length) {
            while (right < nums.length && nums[right] != num) {
                left ++;
                right ++;
            }
            if (right < nums.length) {
                right++;
                while (right < nums.length && nums[right] != num) {
                    right++;
                }
                if (right < nums.length) {
                    nums[left] = nums[right];
                }
            }
        }
        return left + 1;

    }
}
