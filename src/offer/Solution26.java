//package offer;
//
//
//class TreeNode {
//    int val;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}
//
//
//public class Solution26 {
//
//    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
//
//        boolean isTrue = false;
//
//        if (root1 != null && root2 != null) {
//            //表示找到了相等的根结点
//            if (root1.val == root2.val) {
//                isTrue = isEqual(root1, root2);
//            }
//            if (!isTrue) {
//                isTrue = HasSubtree(root1.left, root2);
//            }
//            if (!isTrue) {
//                isTrue = HasSubtree(root1.right, root2);
//            }
//        }
//        return isTrue;
//
//    }
//
//    /**
//     * 判断子树是否是相等的
//     * @param treeNode1
//     * @param treeNode2
//     * @return
//     */
//    private static boolean isEqual(TreeNode treeNode1, TreeNode treeNode2) {
//        if (treeNode2 == null) {
//            return true;
//        }
//        if (treeNode1 == null) {
//            return false;
//        }
//        boolean isTrue = false;
//        if (treeNode1.val == treeNode2.val) {
//            isTrue = isEqual(treeNode1.left, treeNode2.left) && isEqual(treeNode1.right, treeNode2.right);
//        }
//        return isTrue;
//    }
//}
