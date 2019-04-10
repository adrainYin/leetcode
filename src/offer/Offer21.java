package offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 所有的奇数位于偶数之前
 */
public class Offer21 {

    public static void reOrderArray(int [] array) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                list1.add(array[i]);
            }else {
                list2.add(array[i]);
            }
        }
        int index = 0;
        for (int i = 0; i < list1.size(); i++) {
            array[i] = list1.get(i);
            index ++;
        }
        for (int i = 0; i < list2.size(); i++) {
            array[index + i] = list2.get(i);
        }
    }

    /**
     * 如果不考虑相对顺序，则使用双指针法
     * @param nums
     */
    private static void reOrder(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 == 1) {
                left ++;
            } else {
                if (nums[right] % 2 == 1) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left ++;
                    right --;
                } else {
                    right --;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,8,8,8,8};
//        reOrderArray(nums);
        reOrder(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
