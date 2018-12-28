package leetcode;

public class Leetcode31 {

    public static void nextPermutation(int[] nums) {
        if (nums.length == 0){
            return ;
        }
        int length = nums.length;
        boolean isOver = false;
        int i = length - 1;
        while (i - 1 >= 0 ){
            if (nums[i-1] < nums[i]){
                int index = i-1;
                int swapNum = nums[index];
                int start = i;
                //这个方法不好，第二次遍历的时候还是应该逆序遍历，找到第一个大于等于index的数值，然后和该数值之后的第一个数值做对调。
                while (start < length){
                    if (nums[start] <= swapNum){
                        int temp = swapNum;
                        nums[index] = nums[start-1];
                        nums[start-1] = temp;
                        reverseNums(nums, i, length-1);
                        isOver = true;
                        break;
                    }
                    start ++;
                }
                if (isOver){
                    break;
                }
                if (start == length){
                    int temp = nums[length-1];
                    nums[length-1] = swapNum;
                    nums[index] = temp;
                    reverseNums(nums, i, length-1);
                    break;
                }
            }
            i--;
        }
        if (i == 0){
            reverseNums(nums, 0, length-1);
        }
    }
    private static void reverseNums(int[] nums, int left, int right){
        int mid = (left + right) / 2;
        for (int i = 0; i <= mid-left; i++) {
            int temp = nums[left+i];
            nums[left+i] = nums[right-i];
            nums[right-i] = temp;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,4,3,3};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
