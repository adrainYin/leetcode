package tree;

public class Leetcode105 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != 0 && inorder.length != 0){
//            TreeNode root = new TreeNode(preorder[0]);
//            int rootIndex = -1;
//            for (int i = 0; i < inorder.length; i++) {
//                if (inorder[i] == preorder[0]){
//                    rootIndex = i;
//                    break;
//                }
//            }
//            root.left = buildSubTree(preorder, inorder ,1 ,rootIndex, 0, rootIndex - 1);
//            root.right = buildSubTree(preorder, inorder, rootIndex + 1, preorder.length - 1, rootIndex + 1, inorder.length - 1);
//            return root;
            return buildSubTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }
        return null;
    }


    private TreeNode buildSubTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        if (inLeft > inRight || preLeft > preRight){
            return null;
        }
        TreeNode subRoot = new TreeNode(preorder[preLeft]);
        int subRootIndex = -1;
        for (int i = inLeft; i <= inRight; i++) {
            //得到根的节点在中序遍历中的下标
            if (inorder[i] == preorder[preLeft]){
                subRootIndex = i;
                break;
            }
        }
        subRoot.left = buildSubTree(preorder, inorder, preLeft + 1, subRootIndex - inLeft + preLeft, inLeft, subRootIndex -1);
        subRoot.right = buildSubTree(preorder, inorder, subRootIndex - inLeft + preLeft + 1, preRight, subRootIndex + 1, inRight);
        return subRoot;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Leetcode105 leetcode105 = new Leetcode105();
        leetcode105.buildTree(preorder, inorder);
    }
}
