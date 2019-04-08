package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || k == 0) {
            return result;
        }
        dfs(result, n, 1, k, new ArrayList<>());
        return result;
    }

    /**
     *
     * @param result 结果数组
     * @param nextBegin 下一个开始遍历的位置
     * @param needLength 需要的长度
     * @param list 当前的中间结果
     * @return
     */
    public static void dfs(List<List<Integer>> result, int n, int nextBegin, int k, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        //在每次迭代的过程中，当前的list数组都不会改变
        for (int i = nextBegin; i <= n; i++) {
            list.add(i);
            dfs(result, n, i + 1, k, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combine(4,2);
        System.out.println(lists.toString());
    }
}
