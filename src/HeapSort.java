public class HeapSort {

    /**
     * 堆排序，必须要重点掌握
     * @param nums
     * @return
     */
    public static int[] minHeap(int[] nums){
        int end = nums.length - 1;
        int root_index = (end - 1) /2;
        if (root_index < 0){
            return nums;
        }
        while (root_index >= 0) {
            buildHeap(nums, root_index, nums.length - 1);
            root_index --;
        }
        for (int i = nums.length - 1; i > 0 ; i--) {
            swap(nums, 0, i);
            buildHeap(nums, 0, i - 1);
        }
        return nums;
    }

    private static void buildHeap(int[] nums, int root, int end){
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int swap = root;
        if (left <= end && nums[left] > nums[swap]){
            swap = left;
        }
        if (right <= end && nums[right] > nums[swap]){
            swap = right;
        }
        if (swap != root){
            swap(nums, swap, root);
            buildHeap(nums, swap, end);
        }
    }
    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4,7,1,9,2,3,8,11};
        int[] temp = minHeap(nums);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }
}
