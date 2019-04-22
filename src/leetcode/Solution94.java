package leetcode;

import java.io.IOException;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root)  {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode idx = root;
        Stack<TreeNode> stack = new Stack<>();

        while (idx != null || !stack.isEmpty()) {
            while (idx != null) {
                stack.push(idx);
                idx = idx.left;
            }
            idx = stack.pop();
            list.add(idx.val);
            idx = idx.right;
        }
        return list;
    }
}
