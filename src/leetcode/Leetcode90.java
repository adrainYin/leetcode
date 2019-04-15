package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0 ){
            return result;
        }
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        dfs(result, nums, 0, new ArrayList<>());
        return result;
    }

    private static void dfs(List<List<Integer>> result, int[] nums, int index, List<Integer> subList) {
        for (int i = index; i < nums.length; i++) {
            //在本层做第一次dfs的时候，如果有重复也需要加入，第二层迭代的时候如果有重复那么就不能加入
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            } else {
                subList.add(nums[i]);
                result.add(new ArrayList<>(subList));
                dfs(result, nums, i + 1, subList);
                subList.remove(subList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {1,1,2,2}).toString());
    }
}
