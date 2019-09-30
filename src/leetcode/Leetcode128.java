package leetcode;


import java.util.*;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Leetcode128 {


    /**
     * 计数法 ，超时
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add((long)nums[i]);
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        long index = min;
        int count = 0;
        int result = 0;
        while (index <= max) {
            while (index <= max && set.contains(index)) {
                index ++;
                count ++;
            }
            result = Math.max(count, result);
            count = 0;
            index ++;
        }
        return result;
    }

    public static int doSolution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        //用set去重
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int left;
        int right;
        int result = 0;
        for (int num : set) {
            if (!map.containsKey(num - 1) && !map.containsKey(num + 1)) {
                map.put(num, 1);
                result = Math.max(result, 1);
            }
            else if (map.containsKey(num - 1) && !map.containsKey(num + 1)) {
                left = map.get(num - 1);
                map.put(num, left + 1);
                map.put(num - left, left + 1);
                result = Math.max(result, left + 1);
            }
            else if (!map.containsKey(num - 1) && map.containsKey(num + 1)) {
                right = map.get(num + 1);
                map.put(num, right + 1);
                map.put(num + right, right + 1);
                result = Math.max(result,right + 1);
            }
            else {
                left = map.get(num - 1);
                right = map.get(num + 1);
                map.put(num, left + right + 1);
                map.put(num - left, left + right + 1);
                map.put(num + right, left + right + 1);
                result = Math.max(result, left + right + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645};
        System.out.println(doSolution(nums));
    }
}
