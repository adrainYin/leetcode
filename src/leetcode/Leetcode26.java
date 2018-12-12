package leetcode;

public class Leetcode26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int length = nums.length;
        int i = 1;
        while (i < length ){
            if (nums[i] == nums[i - 1]){
                for (int j = i+ 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                length --;
                continue;
            }
            else {
                i ++;
            }
        }
        return length;
    }

    /**
     * 不移动的方法
     * @param nums
     * @return
     */
    private static int method(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[k] != nums[i]){
                k ++;
                nums[k] = nums[i];
            }
        }
        return k+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,2,2,3,3};
        System.out.println(method(nums));
        for (int i = 0; i < method(nums); i++) {
            System.out.println(nums[i]);
        }
    }
}
