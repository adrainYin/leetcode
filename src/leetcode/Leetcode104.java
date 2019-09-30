package leetcode;


/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class Leetcode104 {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return doMaxDepth(root, root);
    }

    private static int doMaxDepth(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return 0;
        }
        if (leftNode != null && rightNode == null) {
            return 1 + doMaxDepth(leftNode.left, leftNode.right);
        }
        if (leftNode == null && rightNode != null) {
            return 1 + doMaxDepth(rightNode.left, rightNode.right);
        }
        //左右子树都不是空
        int left = 1 + doMaxDepth(leftNode.left, leftNode.right);
        int right = 1 + doMaxDepth(rightNode.left, rightNode.right);
        return Math.max(left, right);
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = null;
        treeNode2.left = treeNode3;
        treeNode2.right = null;
        treeNode3.left = treeNode3.right = null;
        System.out.println(maxDepth(treeNode1));
    }
}
