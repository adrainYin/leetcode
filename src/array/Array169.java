package array;

import java.util.HashMap;
import java.util.Map;

public class Array169 {

    /**
     * Hash计数
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        for (Integer integer : map.keySet()){
            if (map.get(integer) > nums.length / 2){
                return integer;
            }
        }
        return 0;
    }

    /**
     * 分治法
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int find(int nums[], int left, int right){

        if (left == right){
            return nums[left];
        }

        int mid = (right + left) / 2;
        int leftMajority = find(nums, left, mid);
        int rightMajority = find(nums, mid + 1, right);

        if (leftMajority == rightMajority){
            return leftMajority;
        }
        else {
            int leftCount = 0;
            int rightCount = 0;
            for (int i = left; i < right + 1; i++) {
                if (nums[i] == leftMajority){
                    leftCount ++;
                }
                if (nums[i] == rightMajority){
                    rightCount ++;
                }
            }
            return leftCount > rightCount ? leftMajority : rightMajority;
        }

    }


    public static int vote(int nums[]){
        int curr_count = 0;
        int curr_num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curr_count == 0){
                curr_num = nums[i];
            }
            if (curr_num == nums[i]){
                curr_count ++;
            }
            else {
                curr_count --;
            }
        }

        return curr_num;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,4,4,4,4,4,4,4,4,4};
        System.out.println(majorityElement(array));
        System.out.println(find(array, 0, array.length - 1));
    }
}
