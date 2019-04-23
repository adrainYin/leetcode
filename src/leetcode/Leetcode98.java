package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Leetcode98 {

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> nums = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            //表示是正常的逻辑
            nums.add(node.val);
            root = node.right;
        }

        //通过中序遍历出顺序，然后逐个比较
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) <= nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode5.left = treeNode1;
        treeNode5.right = treeNode4;
        treeNode1.left = treeNode1.right = null;
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode6;
        treeNode3.left = treeNode3.right = treeNode6.left = treeNode6.right = null;
        System.out.println(isValidBST(treeNode5));
    }



}
