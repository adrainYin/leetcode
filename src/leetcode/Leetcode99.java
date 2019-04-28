package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Leetcode99 {

    public static void recoverTree(TreeNode root) {
        if (root == null) {
            return ;
        }
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode treeNode = stack.pop();
            list.add(treeNode);
            node = treeNode.right;
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i).val;
        }
        Arrays.sort(nums);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).val = nums[i];
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode3;
        treeNode1.right = null;
        treeNode3.left = null;
        treeNode3.right = treeNode2;
        treeNode2.left = treeNode2.right = null;
        recoverTree(treeNode1);
        System.out.println(treeNode1.val);
    }
}
