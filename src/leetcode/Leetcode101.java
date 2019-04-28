package leetcode;

public class Leetcode101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return doJudge(root, root);
    }

    public boolean doJudge(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null ) {
            return false;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return doJudge(left.left, right.right) & doJudge(left.right, right.left);
    }
}
