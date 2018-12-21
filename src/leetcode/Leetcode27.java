package leetcode;

public class Leetcode27 {

    /**
     * 从后向前移动指针
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length;
        while (left < right){
            if (nums[left] != val){
                left ++;
            }
            else {
               while (right > left){
                   right --;
                   if (nums[right] != val){
                       nums[left] = nums[right];
                       break;
                   }
               }
            }
        }
        return left;
    }

    public static int method(int[] nums, int val){
        if (nums.length == 0){
            return 0;
        }
        int index = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val){
                nums[index] = nums[i];
                index ++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        int length = method(nums, 2);
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }

    }
}
