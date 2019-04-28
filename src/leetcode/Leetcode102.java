package leetcode;

import java.util.*;

public class Leetcode102 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        doZigzagLevelOrder(result, root);
        return result;
    }

    public void doZigzagLevelOrder(List<List<Integer>> result, TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int count = queue.size();

            while (count > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                count --;
                list.add(node.val);
            }
            //偶数正向排序
            if (level % 2 == 0) {
                result.add(list);
            }
            else {
                List<Integer> reverseList = new ArrayList<>();
                for (int i = list.size() - 1; i >= 0; i--) {
                    reverseList.add(list.get(i));
                }
                result.add(reverseList);
            }
            level += 1;
        }
    }
}
