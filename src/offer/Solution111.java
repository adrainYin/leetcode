package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution111 {

    static List<List<Integer>> res = new ArrayList<List<Integer>>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if(len==0||nums==null)  return res;

        boolean[] used = new boolean[len];
        List<Integer> list = new ArrayList<Integer>();

        Arrays.sort(nums);
        dfs(nums, used, list, len);
        return res;
    }

    public static void dfs(int[] nums, boolean[] used, List<Integer> list, int len) {
        if(list.size()==len) {
            res.add(new ArrayList<Integer>(list));
            return ;
        }
        for (int i=0; i<len; i++) {
            // 当前位置的数已经在List中了
            if(used[i]) continue;
            // 当前元素与其前一个元素值相同 且 前元素未被加到list中，跳过该元素
            if(i>0 && nums[i]==nums[i-1] && !used[i-1])   continue;
            // 深度优先搜索遍历
            used[i]=true;
            list.add(nums[i]);
            dfs(nums, used, list, len);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,3,2,1,1,4};
        List<List<Integer>> result = permuteUnique(nums);
        return;
    }
}

