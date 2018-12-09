package array;

public class Array189 {

    //交换次序
    public static void rotate(int[] nums, int k) {

        //一定要判断异常情况，
        k = k % nums.length;
        swapNumB(nums, 0, nums.length - 1);
        swapNumB(nums, 0 , k - 1);
        swapNumsA(nums, k, nums.length - 1);

    }
    private static void swapNumsA(int[] nums, int begin, int end){
        int mid  = (begin + end) / 2;
        for (int i = begin; i <= mid; i++) {
            int temp = nums[i];
            nums[i] = nums[end - i + begin];
            nums[end - i + begin] = temp;
        }
    }

    private static void swapNumB(int[] nums, int begin, int end){
        int mid = (begin + end) / 2;
        for (int i = begin; i <= mid; i++){
            int temp = nums[i];
            nums[i] = nums[end - i];
            nums[end - i] = temp;
        }
    }

    /**
     * 开辟多余数组的移动法
     * @param nums
     * @param k
     */
    public static void newArray(int[] nums, int k){
        int[] newInt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newInt[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newInt[i];
        }
    }

    /**
     * 基本的循环方法
     * @param nums
     */
    public static void dorotate(int[] nums, int k){
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j+1] = nums[j];
            }
            nums[0] = last;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        newArray(nums, 2);
        for (int i : nums){
            System.out.println(i);
        }
    }

}
