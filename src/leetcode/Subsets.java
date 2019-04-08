package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        dfs(result, nums, 0, new ArrayList<>());
        return result;
    }

    private static void dfs(List<List<Integer>> result, int[] nums, int currIndex, List<Integer> list) {

        result.add(new ArrayList<>(list));
        for (int i = currIndex; i < nums.length; i++) {
            list.add(nums[i]);

            dfs(result, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
