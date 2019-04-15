package offer;

/**
 * 对称的二叉树
 */
public class Solution28 {

    public static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return doIsSymmetrical(pRoot, pRoot);
    }

    /**
     * 对于结点的左右子树，总是判断左子树的左子树是否和右子树的右子树相同
     * @param pleft
     * @param pRight
     * @return
     */
    private static boolean doIsSymmetrical(TreeNode pleft, TreeNode pRight) {

        if (pleft == null && pRight == null) {
            return true;
        }
        if (pleft == null || pRight == null) {
            return false;
        }

        boolean isTrue = false;
        if (pleft.val == pRight.val) {
            isTrue = doIsSymmetrical(pleft.left, pRight.right) && doIsSymmetrical(pleft.right, pRight.left);
        }
        return isTrue;
    }

}
