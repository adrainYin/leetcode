package leetcode;

public class Leetcode81 {

    public boolean search(int[] nums, int target) {
        return false;
    }

    private boolean doSearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return true;
        }
        //如果大于中间数字，需要判断在较大的升序列还是在较小的升序列
        if (nums[mid] < target) {
            //判断起始数字
            if (nums[left] == target) {
                return true;
            }
            //在较小的升序列

        }
        return false;
    }
}
