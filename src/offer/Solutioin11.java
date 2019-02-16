package offer;

public class Solutioin11 {

    public static int binarySreach(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("数组为空");
        }
        int index = search(nums, 0, nums.length - 1);
        return nums[index];
    }

    private static int search(int[] nums, int left, int right) {
        if (right - left == 1) {
            return nums[left] > nums[right] ? right : left;
        }
        int mid = (left + right) / 2;
        if (nums[mid] < nums[right]) {
            return search(nums, left, mid);
        }
        else if (nums[mid] > nums[right]){
            return search(nums, mid, right);
        }
        //{1,1,1,0,1}
        //{1,0,1,1,1}
        else {
            if (nums[left] != nums[mid]) {
                return search(nums, left, mid);
            }
            //left , mid , right的数值都是相等的
            else {
                int minIndex = left;
                for (int i = left+1; i <= right; i++) {
                    minIndex = nums[i] < nums[minIndex] ? i : minIndex;
                }
                return minIndex;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,1};
        int[] nums2 = {1,0,0,1,1,1};
        System.out.println(binarySreach(nums2));
    }
}
